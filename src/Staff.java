
public class Staff extends Member {

	public Staff( String Name, String Account, String Password, String ID,int Acc,int Num){
		super(Name,Account,Password,ID,Acc,Num);
		setDate(60);
		setfine_perday(3);
	}

}
