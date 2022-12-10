public class Student extends Member {

	public Student( String Name, String Account, String Password, String ID,int Acc,int Num){
		super(Name,Account,Password,ID,Acc,Num);
		setDate(30);
		setfine_perday(1);
	}
}
