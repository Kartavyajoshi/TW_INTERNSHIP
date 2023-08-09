import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM_INTERFACE {
	static ArrayList<account> customer = new ArrayList<>();
	static Scanner in = new Scanner(System.in);
	
	
	
	static void addAccount() {
		account k = new account();
		System.out.println("Account is succesfully open");
		try {
			customer.add(k);
		} catch (Exception e) {
			System.out.println("Account is not opened try againg ..! ERROR : #3FDCVG");
		}
	}

	public static void main(String[] args) {
		
		System.out.println("----------ATM Machine----------"); // heading for ATM
		System.out.println("for new Account press 0 else 1 ");

		try {
			int n1 = in.nextInt();
			try {
			if (n1 == 0) {
				addAccount();
			}
			}
			catch(Exception e) {
				
			}
			System.out.println();
			System.out.println("Enter Account number : ");
			long number = in.nextLong();

			int flag = 0;
			if (customer.size() != 0) {

				for (account a : customer) {
					if (a.getAccountNo() == number) {
						System.out.println("Enter PIN : ");
						int pin = in.nextInt();
						if (a.getPin() == pin) {
							while (true) {

								System.out.println("Choose 1 : for Withdraw");
								System.out.println("Choose 2 : for Deposite");
								System.out.println("Choose 3 : for Check Balance");
								System.out.println("Choose 4 : for for EXIT");
								int choice = in.nextInt();
								switch (choice) {

								case 1:
									System.out.println("Enter Ammount for withdraw  :");
									try {
										int money = in.nextInt();
										a.cutBalance(money);

									} catch (Exception e) {
										System.out.println("not valid...! ERROR : #2#BNEG");
									}
									break;
								case 2:
									System.out.println("Enter Ammount for Deposite  :");
									try {
										int money = in.nextInt();
										a.addBalance(money);

									} catch (Exception e) {
										System.out.println("not valid...! ERROR : #2#BOVR");
									}
									break;
								case 3:
									System.out.println("Your balance is : " + a.getBalance());
									break;
								case 4:
									flag = 1;
									System.out.println("Thanks for using our services....!");
									break;
								default:
									System.out.println("not valid Choice....ERROR  #FE23CC");
									break;
								}
								if (flag == 1) {
									break;
								}
								System.out.println();

							}
						} else {
							System.out.println("Not valid Pin");
							System.out.println("If you forgot enter 1 to reset PIN");
							try {
								int k = in.nextInt();
								if (k == 1) {
									System.out.println("Enter new PIN : ");
									try {
										int p = in.nextInt();
										a.setPin(p);
									} catch (Exception e) {
										System.out.println("Not valid ERROR :#43KFLT");
									}
								}
							} catch (Exception e) {
								System.out.println("Your account block for security");
								System.out.println("ERROR : #CR32GK");
							}
						}
					}

				}
			} else {
				System.out.println("Account not found ERROR : #ER440B");
			}

		} catch (Exception e) {
			System.out.println("Not Valid Account Number.");
			System.out.println("ERROR : #34AGLT");
		}
	}
}

class account {
	Random r1 = new Random();
	private long AccountNo;
	private int PIN;
	private BigInteger phoneno;
	private long AccountBalance;
	Scanner sc = new Scanner(System.in);

	account() {
		// default constructor

		System.out.println("New Account process..");
		AccountBalance = 1000; // add default amount
		AccountNo = r1.nextLong((long) Math.pow(10, 10), (long) Math.pow(11, 10));
		System.out.println("Enter PIN for your account");
		PIN = sc.nextInt();
		System.out.println("Enter register phone number : 10 digit");
		phoneno = sc.nextBigInteger();
		System.out.println();
		System.out.println("Account created AccountNo : " + AccountNo);

	}
	account(int PIN,BigInteger phoneno) {
		// default constructor
		AccountBalance = 1000; // add default amount
		AccountNo = r1.nextLong((long) Math.pow(10, 10), (long) Math.pow(11, 10));
		PIN = this.PIN;
		phoneno = this.phoneno;
		System.out.println();
		System.out.println("Account created AccountNo : " + AccountNo);
	}

	public int getPin() {
		return PIN;
	}

	public void setPin(int x) {
		
		System.out.println("Enter your PhoneNumber name : ");
		BigInteger ans = sc.nextBigInteger();
		if (ans.equals(phoneno)) {
			System.out.println("your Pin change to " + x);
		} else {
			System.out.println("Oops something wrong...contact your bank...!");
			System.out.println("Bank No : 9988776655");
		}
	}

	public void addBalance(int money) {
		AccountBalance += money;
		System.out.println("Ammount added :" + money);
		System.out.println("Transection Id : " + r1.nextInt((int) Math.pow(10, 9)));
	}

	public void cutBalance(int money) {
		AccountBalance -= money;
		if (AccountBalance < 0) {
			System.out.println("Not have proper balance.");
			AccountBalance += money;
			System.out.println("No balance ERROR : #12AD23");
			return;
		}
		System.out.println("Withdraw ammount is : " + money);
		System.out.println("Transection Id : " + r1.nextInt((int) Math.pow(10, 9)));
	}

	public long getAccountNo() {
		return AccountNo;
	}

	public long getBalance() {
		return AccountBalance;
	}
}
