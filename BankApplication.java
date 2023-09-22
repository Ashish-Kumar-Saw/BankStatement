
    import java.util.Scanner;

    public class BankApplication {


        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter your 'Name': ");
            String name=sc.nextLine();
            System.out.println("Enter 'CustomerId' to access your Bank account: ");
            String customerId=sc.nextLine();
            BankAccount obj1=new BankAccount(name,customerId);
            obj1.menu();
        }
    }

    class BankAccount{
        long bal;
        long prevTrans;
        String customerName;
        String customerId;

        BankAccount(String customerName,String customerId){
            this.customerName=customerName;
            this.customerId=customerId;
        }


        void deposit(long amount){
            if(amount!=0){
                bal+=amount;
                prevTrans=amount;
            }
        }

        void withdraw(long amt){
            if(amt!=0 && bal>=amt){
                bal-=amt;
                prevTrans=-amt;
            }
            else if(bal<amt){
                System.out.println("Bank balance insufficient");
            }
        }

        void getPreviousTrans(){
            if(prevTrans>0){
                System.out.println("Deposited: "+prevTrans);
            }
            else if(prevTrans<0){
                System.out.println("Withdrawn: "+Math.abs(prevTrans));
            }
            else{
                System.out.println("No transaction occured");
            }
        }

        void menu(){
            char option;
            Scanner sc=new Scanner(System.in);
            System.out.println("Welcome "+customerName);
            System.out.println("Your ID:"+customerId);
            System.out.println("\n");
            do{
                System.out.println("****************** Choose an option **************************");
                System.out.println("(a) Check Balance");
                System.out.println("(b) Deposit Amount");
                System.out.println("(c) Withdraw Amount");
                System.out.println("(d) Previous Transaction");
                System.out.println("(e) Exit");
                option=sc.next().charAt(0);
                System.out.println("\n");

                switch (option){
                    case 'a':
                        System.out.println("Balance ="+bal);
                        System.out.println("\n");
                        break;
                    case 'b':
                        System.out.println("Enter a amount to deposit :");
                        long amt=sc.nextLong();
                        deposit(amt);
                        System.out.println("\n");
                        break;
                    case 'c':
                        System.out.println("Enter a amount to Withdraw :");
                        long amtW=sc.nextLong();
                        withdraw(amtW);
                        System.out.println("\n");
                        break;
                    case 'd':
                        System.out.println("Previous Transaction:");
                        getPreviousTrans();
                        System.out.println("\n");
                        break;

                    case 'e':
                        break;
                    default:
                        System.out.println("Choose a correct option to proceed");
                        break;
                }

            }while(option!='e');

            System.out.println("Thank you for using our banking services");
        }

    }

