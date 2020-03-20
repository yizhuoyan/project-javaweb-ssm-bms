package entity;
/**
 * 读者
 * @author Administrator
 *
 */
public class ReaderEntity extends UserEntity{

	private int age;
	private boolean male;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	
}
