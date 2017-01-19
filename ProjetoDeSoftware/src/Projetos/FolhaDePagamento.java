
package Projetos;

import java.util.Scanner;

public class FolhaDePagamento {
    
    public static void main(String[] args){
        
        int i, j, d;
        String c;
        int max = 100;
        Employee[] emp = new Employee[max];
        Scanner input  = new Scanner(System.in);
  
        for(i = 0; i < 100; i++){
            emp[i] = new Employee();
        }
        
        // TESTS
        
        emp[0].name = "John Locke";
        emp[0].address = "Lost Island";
        emp[0].type = 2; // Assalariado
        emp[0].payment = 2; // Mensal
        emp[0].payday = 15; // Dia do mês a receber
        emp[0].workHours = 160; // Horas trabalhadas
        emp[0].salary = 2000.00; // Salário mensal
        emp[0].id = 0; // Número de identificação
        
        emp[1].name = "Nemo";
        emp[1].address = "P sherman, 42 wallaby way, Sydney";
        emp[1].type = 1; // Horista
        emp[1].payment = 1; // Por horas trabalhadas
        emp[1].payday = 7; // Dia do mês a receber
        emp[1].workHours = 80; // Horas trabalhadas
        emp[1].salary = (emp[1].workHours * 20); /* Salário calculado em função 
                das horas trabalhadas vezes uma taxa de R$ 20,00
                */
        emp[1].id = 1; // Número de identificação
        
        emp[2].name = "Ted Mosby";
        emp[2].address = "Maclaren's Pub, New York City";
        emp[2].type = 3; // Comissionista
        emp[2].payment = 3; // Comissão
        emp[3].payday = 10; // Dia do mês a receber
        emp[3].workHours = 0; /* 0 representa que o salário independe das horas
        de serviço
        */
        emp[3].salary = 20000 * 0.10; /* Recebe 10% do faturamento do setor
        de vendas da empresa
        */
        emp[3].id = 3; // Número de identificação
       
        short n;
        i = 4;

        do{
            System.out.println("Please, insert the number of your action:");
            System.out.println("1 - Add a new employee");
            System.out.println("2 - Remove an employee");
            System.out.println("3 - Launch a new Time Card");
            System.out.println("4 - Launch a new Sold Result");
            System.out.println("5 - Launch a Service Charge");
            System.out.println("6 - Change some details of a new an employee");
            System.out.println("7 - Show the Payroll");
            System.out.println("8 - Undo / Redo");
            System.out.println("9 - Play the Payroll");
            System.out.println("10 - Create news payRoll");     
            System.out.println("0 - Exit");
            
            n = input.nextShort();
            c = input.nextLine();
            
            switch(n){
                case 0:
                    System.out.println("Thank you for been using our services!");
                    break;
                case 1: // ADD A NEW EMPLOYEE
                    
                    System.out.println("Let's add a new Employee");
                    
                    System.out.println("Name:");
                    emp[i].name = input.nextLine();
                    System.out.println("Address:");
                    emp[i].address = input.nextLine();
                    System.out.println("Type of Employee:");
                    System.out.println("1 - Hourly");
                    System.out.println("2 - Salaried");
                    System.out.println("3 - Commissioned");
                    emp[i].type = input.nextInt();
                    System.out.println("Type of Payment:");
                    System.out.println("1 - Hourly");
                    System.out.println("2 - Monthly");
                    System.out.println("3 - commission");
                    emp[i].type = input.nextInt();
                    emp[i].id = i;
                    
                    System.out.println(emp[i].name + " Was added!");
                    i++;
                    
                    break;
                case 2:
                    System.out.println("Please Insert the ID of The Employee");
                    j = input.nextInt();
                    System.out.println("Do you really wanna dismiss " + emp[j].name + "?");
                    System.out.println("1 - Yes");
                    System.out.println("2 - No");
                    d = input.nextInt(); // Decisão
                    if(d == 1){
                        emp[j] = null;
                    }
                    
                    break;
                case 3:
                    System.out.println("Okay... Let's go");
                    break;
                default:
                    System.out.println("Invalid Number, please try again");
            }
        }while(n != 0);
    }
    
}
