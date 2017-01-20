
package Projetos;

import java.util.Scanner;

public class FolhaDePagamento {
    
    static Employee[] add(Employee[] emp, int i){
        
        Scanner input  = new Scanner(System.in);
  
        System.out.println("Let's add a new Employee");
        
        System.out.println("Name:");
        
        emp[i].name = input.nextLine();
        
        System.out.println("Address:");
        
        emp[i].address = input.nextLine();
        
        System.out.println("Belongs to the syndicate?");
        System.out.println("1 - Yes");
        System.out.println("2 - No");
        
        emp[i].syndicate = input.nextInt();
            if(emp[i].syndicate == 1){
                System.out.println("Insert the Union Fee:");
                emp[i].unionFee = input.nextDouble();
            }
        
        System.out.println("Type of Employee:");
        System.out.println("1 - Hourly");
        System.out.println("2 - Salaried");
        System.out.println("3 - Commissioned");
        
        emp[i].type = input.nextInt();
        
        switch (emp[i].type) {
            case 1:
                System.out.println("How much per hour?");
                emp[i].perHour = input.nextDouble();
                break;
            case 2:
                System.out.println("Salary:");
                emp[i].salary = input.nextDouble();
                break;
            case 3:
                System.out.println("What is the percentage of your billing?");
                emp[i].perCom = input.nextDouble();
                break;
            default:
                break;
        }
        System.out.println("Type of Payment:");
        System.out.println("1 - Hourly");
        System.out.println("2 - Monthly");
        System.out.println("3 - commission");
        
        emp[i].payment = input.nextInt();
            if(emp[i].payment == 2){
                System.out.println("When is the payday?");
                emp[i].payday = input.nextInt();
            }
            else if(emp[i].payment == 3){
                System.out.println("By Convention of our company, he will been receiving out by day 15");
                emp[i].payday = 15; // CONVENÇÃO 
            }
        
        emp[i].id = i;
        
        System.out.println("The number of ID is: " + i);
                    
        return emp;
    }
    
    static Employee[] remove(Employee[] emp, int j){
        
        emp[j].name = null;
        emp[j].address = null;
        emp[j].type = 0;
        emp[j].payment = 0;
        emp[j].payday = 0;
        emp[j].workHoursTotal = 0;
        emp[j].id = -1; /* Tag -1 para indentificar posição
        livre no array de empregados
        */ 
        
        return emp;
    }
    
    
    static Employee[] edit(Employee[] emp, int j){
        
        int d, n;
        String c;
        Scanner input  = new Scanner(System.in);
        
        do{
            
            System.out.println("Please, insert the number of your action:");
            System.out.println("1 - Name");
            System.out.println("2 - Address");
            System.out.println("3 - Syndicate");
            System.out.println("4 - Type of Employee");
            System.out.println("5 - Type of payment");
            System.out.println("6 - ID");
            System.out.println("7 - Union fee");
            System.out.println("0 - Exit");

            n = input.nextInt();
            
            switch(n){
                case 0:
                    break;
                case 1:
                    System.out.println("Would you like to change the name of " + emp[j].name + " ?");
                    System.out.println("1 - Yes");
                    System.out.println("2 - No");
                    d = input.nextInt();
                    c = input.nextLine(); // Pegando /n do ultimo scanner
                        if(d == 1){
                            System.out.println("Please, insert the new name:");
                            emp[j].name = input.nextLine();
                        }
                    break;
                case 2:
                    System.out.println("Would you like to change the address, " + emp[j].address + " ?");
                    System.out.println(emp[j].address);
                    System.out.println("1 - Yes");
                    System.out.println("2 - No");
                    d = input.nextInt();
                    c = input.nextLine(); // Pegando /n do ultimo scanner
                        if(d == 1){
                            System.out.println("Please, insert the new address:");
                            emp[j].address = input.nextLine();
                        }
                    break;
                case 3:
                    System.out.println("Do you belongs to the syndicate?");
                    System.out.println("1 - Yes");
                    System.out.println("2 - No");
                    d = input.nextInt();
                    emp[j].syndicate = d;
                    break;
                case 4:
                    System.out.println("Right now you are from " + emp[j].type + " type of Employee");
                    System.out.println("Choose a newone:");
                    System.out.println("1 - Hourly");
                    System.out.println("2 - Salaried");
                    System.out.println("3 - Commissioned");
                    emp[j].type = input.nextInt();
                    switch(emp[j].type){
                            case 1:
                                System.out.println("How much per hour do you won?");
                                emp[j].perHour = input.nextDouble();
                                break;
                            case 2:
                                System.out.println("The new Salary is:");
                                emp[j].salary = input.nextDouble();
                                break;
                            case 3:
                                System.out.println("What is the percentage of your billing?");
                                emp[j].perCom = input.nextDouble();
                                break;
                            default:
                                break;
                        }
                    break;
                case 5:
                    System.out.println("Right now you receive by " + emp[j].type + " type");
                    System.out.println("Choose a different:");
                    System.out.println("1 - Hourly");
                    System.out.println("2 - Monthly");
                    System.out.println("3 - commission");

                    emp[j].payment = input.nextInt();
                        if(emp[j].payment == 2){
                            System.out.println("When is the payday?");
                            emp[j].payday = input.nextInt();
                        }
                        else if(emp[j].payment == 3){
                            System.out.println("By Convention of our company, he will been receiving out by day 15");
                            emp[j].payday = 15; // CONVENÇÃO 
                        }
                    break;
                case 6:
                    System.out.println("Would you like to change the ID " + emp[j].id + " ?");
                    System.out.println("1 - Yes");
                    System.out.println("2 - No");
                    d = input.nextInt();
                        if(d == 1){
                            System.out.println("Please, insert the new ID (1 - 100):");
                            while(emp[d-1].id != 0 && emp[d-1].id != -1){
                                System.out.println("This ID are already been using, choose anotherone:");
                                d = input.nextInt();
                            }
                            emp[j].id = d;
                            System.out.println("The new ID is " + emp[j].id);
                        }
                    break;
                case 7:
                    System.out.println("Union fee current: " + emp[j].unionFee);
                    System.out.println("Would you like to change ?");
                    System.out.println("1 - Yes");
                    System.out.println("2 - No");
                    d = input.nextInt();
                        if(d == 1){
                            System.out.println("Please, insert the new value:");
                            emp[j].unionFee = input.nextDouble();
                        }
                    break;
            }
        }while(n != 0);
            
        return emp;
    }
    
    static int overflow(int i, Employee[] emp){
        if(i < 100)return i;
        int k;
        /*
            Procurar um espaço vazio, devido a uma previa remoção de
        algum empregado, no array de empregados
        */
        for(k = 0; k < 100; k++){ 
            if(emp[k].id == -1){
                return k;
            }
        }
        return -1;
    }
    
    static Employee[] copyStatusArray(Employee[] emp, Employee[] copy, int i){
        
        /* Salvar as informações, criando uma copia, antes de qualquer
        ação para o caso UNDO
        */
        int k;
        for(k = 0; k < i; k++)
        {
            copy[k].name = emp[k].name;
            copy[k].address = emp[k].address;
            copy[k].type = emp[k].type;
            copy[k].syndicate = emp[k].syndicate;
            copy[k].payday = emp[k].payday;
            copy[k].payment = emp[k].payment;
            copy[k].incomeService = emp[k].incomeService;
            copy[k].salary = emp[k].salary;
            copy[k].unionFee = emp[k].unionFee;
            copy[k].perCom = emp[k].perCom;
            copy[k].perHour = emp[k].perHour;
            copy[k].hourArrive = emp[k].hourArrive;
            copy[k].hourLeave = emp[k].hourLeave;
            copy[k].id = emp[k].id;
            copy[k].workHoursToday = emp[k].workHoursToday;
            copy[k].workHoursTotal = emp[k].workHoursTotal;
        }
        return copy;
    }
    
    public static void main(String[] args){
        
        int i, j, d;
        String c;
        String newappBook;
        int max = 100;
        int r; // Guardar o faturamento da empresa
        double t; // Pegar uma taxa de serviço
        
        Employee[] emp = new Employee[max];
        Employee[] copy = new Employee[max];
        Scanner input  = new Scanner(System.in);
  
        for(i = 0; i < 100; i++){
            emp[i] = new Employee();
            copy[i] = new Employee();
        }
        
        // TESTS
        
        emp[0].name = "John Locke";
        emp[0].address = "Lost Island";
        emp[0].syndicate = 1; // Pertence ao sindicato
        emp[0].unionFee = 0.05; // Taxa sindical a ser descontada
        emp[0].type = 2; // Assalariado
        emp[0].payment = 2; // Mensal
        emp[0].payday = 15; // Dia do mês a receber
        emp[0].workHoursTotal = 160; // Horas trabalhadas
        emp[0].salary = (3000.00 * (1 - emp[0].unionFee)); // Salário mensal
        emp[0].id = 1; // Número de identificação
        
        emp[1].name = "Nemo";
        emp[1].address = "P sherman, 42 wallaby way, Sydney";
        emp[1].syndicate = 2; // Não pertence ao sindicato
        emp[1].type = 1; // Horista
        emp[1].perHour = 20;
        emp[1].payment = 1; // Por horas trabalhadas
        emp[1].payday = 7; // Dia do mês a receber
        emp[1].workHoursTotal = 80; // Horas trabalhadas
        emp[1].salary = (emp[1].workHoursTotal * emp[1].perHour); /* Salário calculado em função 
                das horas trabalhadas vezes uma taxa de R$ 20,00
                */
        emp[1].id = 2; // Número de identificação
        
        emp[2].name = "Ted Mosby";
        emp[2].address = "Maclaren's Pub, New York City";
        emp[2].syndicate = 1; // Pertence ao sindicato
        emp[2].unionFee = 0.05; // Taxa sindical a ser descontada
        emp[2].type = 3; // Comissionista
        emp[2].perCom = 0.10;
        emp[2].payment = 3; // Comissão
        emp[2].payday = 10; // Dia do mês a receber
        emp[2].workHoursTotal = 0; /* 0 representa que o salário independe das horas
        de serviço
        */
        emp[2].salary = (20000 * emp[2].perCom); /* Recebe 10% do faturamento do setor
        de vendas da empresa
        */
        emp[2].id = 3; // Número de identificação
       
        short n;
        i = 4; // Controle do numero de empregados

        do{
            System.out.println("------------- RoboVision 2000 -------------");
            
            System.out.println("Please, insert the number of your action:");
            System.out.println("1 - Add a new employee");
            System.out.println("2 - Remove an employee");
            System.out.println("3 - Punch the clock");
            System.out.println("4 - Launch a new Sold Result");
            System.out.println("5 - Launch a Service Charge");
            System.out.println("6 - Change some details of a new an employee");
            System.out.println("7 - Show the Payroll");
            System.out.println("8 - Undo / Redo");
            System.out.println("9 - Play the Payroll");
            System.out.println("10 - Create news payRoll");     
            System.out.println("0 - Exit");
            
            n = input.nextShort(); // Captura a ação desejada
            c = input.nextLine(); // Pegando /n do ultimo scanner
            
            if(n < 8){
                copy = copyStatusArray(emp, copy, i);
            }
            
            switch(n){
                
                case 0: // Sair
                    
                    System.out.println("Thank you for been using our services!");
                    
                    break;
                
                case 1: // Adicionar um novo empregado
                   
                    int o = overflow(i, emp); // Verificação de vagas na empresa
                    
                    if(o == -1){
                        System.out.println("There is no vagas");
                    }
                    
                    emp = add(emp, o); // Adicionar empregado
                    
                    System.out.println(emp[o].name + " Was added!");
                    
                    i++;
                    
                    break;
                
                case 2: // Remover um empregado
                    
                    System.out.println("Please Insert the ID of The Employee");
                    j = input.nextInt();
                    if(emp[j].name == null){
                        System.out.println("ID not find");
                    }
                    else{
                        System.out.println("Do you really wanna dismiss " + emp[j].name + "?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        d = input.nextInt(); // Decisão

                        if(d == 1){
                            emp = remove(emp, j);
                        }
                    }
                    
                    break;
                    
                case 3: // BATER O PONTO!
                    
                    System.out.println("Please, insert your ID:");
                    
                    j = input.nextInt();
                    
                    System.out.println("Are you arriving?");
                    System.out.println("1 - Yes");
                    System.out.println("2 - No");
                    
                    d = input.nextInt();
                    
                        if(d == 1){
                            System.out.println("What time is it? (Hours*)");
                            emp[j].hourArrive = input.nextInt();
                        }
                        else{
                            System.out.println("Are you leaving?");
                            System.out.println("1 - Yes");
                            System.out.println("2 - No");
                            d = input.nextInt();
                                if(d == 1){
                                    System.out.println("What time is it? (Hours*)");
                                    emp[j].hourLeave = input.nextInt();
                                    emp[j].workHoursToday = (emp[j].hourLeave - emp[j].hourArrive);
                                    System.out.println(emp[j].workHoursToday + "hrs did you worked today");
                                    emp[j].workHoursTotal += emp[j].workHoursToday;
                                }
                        }
                        
                    break;
                
                case 4: // Resultado de venda
                    
                    System.out.println("Please, insert the result:");
                    r = input.nextInt();
                    System.out.println("Please, insert the ID of whom sell");
                    j = input.nextInt();
                    if(emp[j].type == 3){ // Recebe uma comissão!
                        emp[j].salary += (r * emp[j].perCom);
                    }
                    
                    break;
                    
                case 5: // Taxa de serviço
                    
                    System.out.println("Please, report an income service");
                    t = input.nextDouble();
                    System.out.println("Please, reference to what employee?");
                    System.out.println("ID:");
                    j = input.nextInt();
                    emp[j].incomeService = t;
                            
                    break;
                    
                case 6: // Alterar dados
                    
                    System.out.println("Please, insert the ID");
                    j = input.nextInt();
                    if(emp[j].name == null){
                        System.out.println("ID not find");
                    }
                    else{
                        
                        System.out.println("Do you change any data of " + emp[j].name + "?");
                        System.out.println("1 - Yes");
                        System.out.println("2 - No");
                        d = input.nextInt(); // Decisão

                        if(d == 1){
                            emp = edit(emp, j);
                        }
                    }
                    
                    break;
                
                case 7: // RODAR FOLHA DE PAGAMENTO
                    
                    System.out.println("Please, insert the day of payment");
                    int p = input.nextInt();
                    int k; // indice de busca
                    double x; // Capturar o salário pago
                    
                    for(k = 0; k < i; k++){
                        
                        if(emp[k].payday == p){
                            
                            System.out.println(emp[k].name);
                            switch (emp[k].type) {
                                case 1:
                                    // HORISTA
                                    x = (emp[k].workHoursTotal * emp[k].perHour);
                                    if(emp[k].syndicate == 1){
                                        x *= (1 - emp[k].unionFee);
                                    }
                                    if(emp[k].incomeService > 0){
                                        x *= (1 - emp[k].incomeService);
                                    }
                                    System.out.println(emp[k].name + " recebeu " + x);
                                    break;
                                case 2:
                                    // MENSAL
                                    x = emp[k].salary;
                                    if(emp[k].syndicate == 1){
                                        x *= (1 - emp[k].unionFee);
                                    }
                                    if(emp[k].incomeService > 0){
                                        x *= (1 - emp[k].incomeService);
                                    }
                                    System.out.println(emp[k].name + " recebeu " + x);
                                    break;
                                case 3:
                                    // COMISSIONADO
                                    x = emp[k].salary;
                                    if(emp[k].incomeService > 0){
                                        x *= (1 - emp[k].incomeService);
                                    }
                                    System.out.println(emp[k].name + " recebeu " + x);
                                    emp[k].salary = 0;
                                    break;
                                default:
                                    break;
                            }
                            emp[k].workHoursTotal = 0;
                        }
                    }
                    break;
                case 8: // UNDO / REDO
                    
                    emp = copy; /* Copiar para o array informações anteriores
                    a ultima ação realizada
                    */
                    
                    break;
                    
                case 9: // AGENDA DE PAGAMENTO
                    
                    System.out.println(" ------- Appointment books ----------");
                    
                    System.out.print("\nInsert your ID:\n");
                    j = input.nextInt();
                    
                    System.out.print(emp[j].name + " choose a way to receive:\n\n");
                    
                    System.out.println("1 - Weekly");
                    System.out.println("2 - Monthly");
                    System.out.print("3 - bi-weekly\n");
                    
                    d = input.nextInt();
                    
                    emp[j].appBook = d;
                    
                    System.out.println(emp[j] + " way choosed");
                    
                    break;
                
                case 10:
                    
                    System.out.println("Let's create a new Appointment books");
                    newappBook = input.nextLine();
                    
                    break;
                
                default:
                    System.out.println("Invalid Number, please try again");
                    break;
            }
            System.out.print("\n");
            
        }while(n != 0);
    }
    
}
