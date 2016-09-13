import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<Resume> resumes = request.session().attribute("resumes");
      if (resumes == null) {
        resumes = new ArrayList<Resume>();
        request.session().attribute("resumes", resumes);
      }

      String title = request.queryParams("user-title");
      String company = request.queryParams("user-company");
      String location = request.queryParams("user-location");
      String description = request.queryParams("user-description");
      int yearStart = Integer.parseInt(request.queryParams("user-start"));
      int yearEnd = Integer.parseInt(request.queryParams("user-end"));
      Resume job = new Resume(title, company, location, description, yearStart, yearEnd);
      resumes.add(job);
      Collections.sort(resumes, Resume.yearSort);
      model.put("resumes", request.session().attribute("resumes"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
