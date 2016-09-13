import java.util.Comparator;

public class Resume {
  private String mTitle;
  private String mCompany;
  private String mLocation;
  private String mDescription;
  private int mStartDate;
  private int mEndDate;

  public Resume(String title, String company, String location, String description, int startDate, int endDate) {
    mTitle = title;
    mCompany = company;
    mLocation = location;
    mDescription = description;
    mStartDate = startDate;
    mEndDate = endDate;
  }

  public String getTitle() {
    return mTitle;
  }

  public String getCompany() {
    return mCompany;
  }

  public String getLocation() {
    return mLocation;
  }

  public String getDescription() {
    return mDescription;
  }

  public int getStartDate() {
    return mStartDate;
  }

  public int getEndDate() {
    return mEndDate;
  }

  public static Comparator<Resume> yearSort = new Comparator<Resume>() {

   public int compare(Resume r1, Resume r2) {

      int rYear1 = r1.getStartDate();
      int rYear2 = r2.getStartDate();

      return rYear1 - rYear2;
    }
  };
}
