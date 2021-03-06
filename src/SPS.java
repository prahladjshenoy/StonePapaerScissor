import java.util.Random;
import java.util.Scanner;

public class SPS {
    int totalMatchs=0,wins=0,loss=0 ,themes=1;

    int introdution(){
        this.cleanTerminal();
        Scanner in =new Scanner(System.in);
        int option;
        
        System.out.println("============================================");
        System.out.println("||   โStone ** ๐คPaper ** โScissor     ||");
        System.out.println("============================================");
        System.out.println("\t1.Start");
        System.out.println("\t2.Themes");
        System.out.println("\t3.How to Play");
        System.out.println("\t4.Quit");
        System.out.print("\n Enter the Option :");
        option=in.nextInt();

        return option;
    }


    void start(){
        this.cleanTerminal();
        Random random=new Random();
        Scanner in =new Scanner(System.in);
        int yourChoise,botChoise,option;

        System.out.println("๐ฑโ๐   Match Begins  ๐ฑโ๐");
        System.out.println("\nPress : \n\t 0 for Stone \n\t 1 for Paper \n\t 2 for Scissor");
        yourChoise=in.nextInt();
        botChoise= random.nextInt(3);

        this.totalMatchs += 1 ;
        this.cleanTerminal();
        String botSymbol= setSymbol(botChoise);
        String yourSymbol= setSymbol(yourChoise);
        System.out.println("-----------------");
        System.out.println("|  Bot  |  You  |");
        System.out.println("-----------------");
        System.out.println("|  "+botSymbol+"  |  "+yourSymbol+"  |");
        System.out.println("-----------------");

        if(yourChoise > 2 || yourChoise < 0)
            this.start();

        if (yourChoise == botChoise){
            System.out.println("\n == Match Draw  ==\n");
        } else {

            
            if((yourChoise == 0 && botChoise == 2) || (yourChoise == 1 && botChoise == 0) || (yourChoise == 2 && botChoise == 1)  ){
                System.out.println("\n ๐ You won  ๐\n");
                this.wins += 1;
            } else {
                System.out.println("\n ๐ You Loss  ๐");
                System.out.println("Try again ..AllThe Best ๐\n");
                this.loss += 1;
            }   
        }

        System.out.println("..........................................................................");
        System.out.println("Score Bord ๐: \n\nTotal Matchs : "+this.totalMatchs+"\t ๐ Won : " +this.wins+"\t ๐ฅบ Loss : "+this.loss+" \t ๐ค Draw :"+(this.totalMatchs -(this.loss+this.wins)));
        System.out.println("..........................................................................");

        selectCorrtectOption:{

            System.out.println("\nPress \n\t1 to Play Again \n\t 0 to Quit");
            option=in.nextInt();
            
            switch (option) {
                case 1:
                this.start();
                break;
                case 0:
                System.out.println("๐ Thank you for Playing  ๐");
                System.exit(1);
                default:
                System.out.println("****** Select the corrtect option ******");
                break selectCorrtectOption;
            }
            
        }
    }
    void howToPlay(){
        this.cleanTerminal();
        Scanner in =new Scanner(System.in);
        int option;
    
        System.out.println("* Stone ** Paper ** Scissor * is a hand game and played between two people, in which each player simultaneously forms one of three shapes. The winner of the game is decided as per the below rules:\n");
        System.out.println("\t โStone vs ๐คPaper -> ๐คPaper wins.");
        System.out.println("\t โStone vs โScissor -> โStone wins.");
        System.out.println("\t ๐คPaper vs โScissor -> โScissor wins");
        System.out.println("\n########################################################\n");
        
        System.out.println("Press \n\t 1 to start the Game \n\t 0 to main menu");
        option=in.nextInt();
    
        switch (option) {
            case 1:
                this.start();
                break;
            case 0:
                this.introdution();
            default:
                this.cleanTerminal();
                System.out.println("****** Select the corrtect option ******");
                this.howToPlay();
                break;
        }
        
    }

    void themes(){
        this.cleanTerminal();
        Scanner in =new Scanner(System.in);
        int option;

        System.out.println("Select themes below:");
        System.out.println("\t 1. Hand themes ( โ , ๐ค , โ )");
        System.out.println("\t 2. Native themes ( ๐ , ๐งป , โ )");
        System.out.print("Enter the themes number : ");
        option=in.nextInt();

        if(option == 2 )
            this.themes=2;
        this.start();
    }

    String setSymbol(int input){
        String set=null;
        if(this.themes == 2)
            input +=3;
        switch(input){
            case 0:
                set= "โ";
                break;
            case 1:
                set= "๐ค";
                break;
            case 2:
                 set= "โ";
                 break;
            case 3:
                 set= "๐";
                 break;
             case 4:
                 set= "๐งป";
                 break;
             case 5:
                  set= "โ";
                  break;
            default:
                break;
        }
        return set;
    }
    void cleanTerminal(){
         //clear the terminal
         System.out.print("\033[H\033[2J");  
         System.out.flush();
    }
    public static void main(String[] args) throws Exception {
        SPS objApp=new SPS();
        int option;

        option = objApp.introdution();
        switch (option) {
            case 1:
                objApp.start();     
                break;
            case 2:
                objApp.themes();     
                break;
            case 3:
                objApp.howToPlay();     
                break;
            case 4:
                System.out.println("๐ Thank you for Playing  ๐");
                System.exit(1);     
                break;
        
            default:
                objApp.cleanTerminal();
                System.out.println("****** Select the corrtect option ******");
                objApp.introdution();
                break;
        }


    } 
}
