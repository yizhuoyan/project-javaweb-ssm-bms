package formbean;
/**
 * formbean 
 * 封装作者相关参数
 * @author Administrator
 *
 */
public class AuthorFB {

	private String name;
	private String age;
	private String birthDay;
	private String deadDay;
	private String intro;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getDeadDay() {
		return deadDay;
	}
	public void setDeadDay(String deadDay) {
		this.deadDay = deadDay;
	}
	@Override
	public String toString() {
		return "AuthorFB [name=" + name + ", age=" + age + ", birthDay=" + birthDay + ", deadDay=" + deadDay
				+ ", intro=" + intro + "]";
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	
	
}
