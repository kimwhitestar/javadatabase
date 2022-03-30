package t4_DBTest_VO;

public class DBTestVO {
  private int idx;  
  private String name;    
  private int age; 
  private String gender; 
  private String joinday;
  
  public DBTestVO() {}
  public DBTestVO(int idx, String name, int age, String gender, String joinday) {
    this.idx = idx;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.joinday = joinday;
  }
  
  public int getIdx() {
    return idx;
  }
  public void setIdx(int idx) {
    this.idx = idx;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public String getJoinday() {
    return joinday;
  }
  public void setJoinday(String joinday) {
    this.joinday = joinday;
  }
  
  //Alt+s+s+s Enter Enter
  @Override
  public String toString() {
    return "DBTestVO [idx=" + idx + ", name=" + name + ", age=" + age + ", gender=" + gender + ", joinday=" + joinday
        + "]";
  }
  
}
