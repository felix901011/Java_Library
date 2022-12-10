public class Teacher extends Member{
	
	public Teacher( String Name, String Account, String Password, String ID,int Acc,int Num){
		super(Name,Account,Password,ID,Acc,Num);
		setDate(90);
		setfine_perday(5);
	}
}
