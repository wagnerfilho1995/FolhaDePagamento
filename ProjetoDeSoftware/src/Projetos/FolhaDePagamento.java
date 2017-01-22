
package Projetos;

import java.util.Scanner;

public class FolhaDePagamento {
    
    static Employee[] add(Employee[] emp, int i){
        
        Scanner input  = new Scanner(System.in);
  
        System.out.println("+++++ Let's add a new Employee +++++");
        
        System.out.println("Full name:");
        
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
                System.out.println("How much per hour? ( R$ )");
                emp[i].perHour = input.nextDouble();
                emp[i].perHour /= 100;
                System.out.println("By default of our company, " + emp[i].name
                + " will be receiving a check in your house by fridays");
                break;
            case 2:
                System.out.println("Salary:");
                emp[i].salary = input.nextDouble();
                System.out.println("By default of our company, " + emp[i].name
                + " will be receiving a check in your house every 15th day mounthly");
                emp[i].payday = 15;
                break;
            case 3:
                System.out.println("Salary Fixed:");
                emp[i].salary = input.nextDouble();
                System.out.println("How much per commission? ( % )");
                emp[i].perCom = input.nextDouble();
                emp[i].perCom /= 100;
                System.out.println("By default of our company, " + emp[i].name
                + " will be receiving a check in your house two by two fridays");
                break;
            default:
                break;
        }
        
        System.out.println("Obs: The way of payment can be change later");
        
        emp[i].id = i;
        
        System.out.println("The number of ID is: " + i);
                    
        return emp;
    }
    
    static Employee[] remove(Employee[] emp, int j){
        
        emp[j].name = null;
        emp[j].address = null;
        emp[j].type = 0;
        emp[j].payday = 0;
        emp[j].workHoursTotal = 0;
        emp[j].id = -1; 
        /* 
            Tag -1 para indentificar posição livre no array de empregados
        */ 
        
        return emp;
    }
    
    
    static Employee[] edit(Employee[] emp, int j){
        
        int d, n;
        String c;
        Scanner input  = new Scanner(System.in);
        
        do{
            
            System.out.println("***** Editing *****");
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
                case 0: // SAIDA
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
                        if(d == 1){
                            System.out.println("Insert the Union Fee:");
                            emp[j].unionFee = input.nextDouble();
                        }
                    break;
                case 4:
                    System.out.println("Right now you are from " + emp[j].type + " type of Employee");
                    System.out.println("Choose a newone:");
                    System.out.println("1 - Hourly");
                    System.out.println("2 - Salaried");
                    System.out.println("3 - Commissioned");
                    System.out.println("0 - Don't wanna change");
                    emp[j].type = input.nextInt();
                    switch(emp[j].type){
                            case 1:
                                System.out.println("How much per hour? ( R$ )");
                                emp[j].perHour = input.nextDouble();
                                System.out.println("By default of our company, " + emp[j].name
                                + " will be receiving a check in your house by fridays");
                                break;
                            case 2:
                                System.out.println("The new Salary is:");
                                emp[j].salary = input.nextDouble();
                                System.out.println("By default of our company, " + emp[j].name
                                + " will be receiving a check in your house every 15th day mounthly");
                                emp[j].payday = 15;
                                break;
                            case 3:
                                System.out.println("Salary Fixed:");
                                emp[j].salary = input.nextDouble();
                                System.out.println("How much per commission? ( % )");
                                emp[j].perCom = input.nextDouble();
                                emp[j].perCom /= 100;
                                System.out.println("By default of our company, " + emp[j].name
                                + " will be receiving a check in your house two by two fridays");
                                break;
                            default:
                                break;
                        }
                    
                    break;
                    
                case 5:
                    
                    System.out.println("We currently send payments by bank check");
                    System.out.println("Would you like to receive by another way?");
                    System.out.println("1 - Bank Check on hand");
                    System.out.println("2 - Deposit into bank account");
                    System.out.println("3 - Don't wanna change");
                    
                    d = input.nextInt();
                        if(d == 1){
                            emp[j].payment = d;
                            System.out.println("Done! Now you will gonna be receiving your paycheck on your hands");
                        }
                        else if(d == 2){
                            emp[j].payment = d;
                            System.out.println("Done! Now your payment will be deposited into your bank account");
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
                    System.out.println("Would you like to change?");
                    System.out.println("1 - Yes");
                    System.out.println("2 - No");
                    d = input.nextInt();
                        if(d == 1){
                            System.out.println("Please, insert the new value:");
                            emp[j].unionFee = input.nextDouble();
                        }
                    
                    break;
                    
                default:
                    break;
            }
            
        } while(n != 0);
            
        return emp;
    }
    
    static int overflow(int i, Employee[] emp){
        if(i < 100 || emp[i].id == -1) return i;
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
            copy[k].appBook = emp[k].appBook;
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
    
    public static int isFriday(int f, int day){
        if(day == f){
            // Hoje é sexta feira!!
        	f += 7;
        	if(f > 30) f -= 30;
            return f; // Retorna a próxima sexta-feira do mês
        }
        return 0;
    }
    
    public static int checkId(Employee[] emp, int i){
        if(emp[i].id == 0 || emp[i].id == -1){
            return 0;
        }
        return 1;
    }
    
    public static int weekday(){
        short w;
        
        System.out.println("Whitch day of the week?");
        
        Scanner input  = new Scanner(System.in);
        
        System.out.println("1 - Sunday");
        System.out.println("2 - Monday");
        System.out.println("3 - Tuesday");
        System.out.println("4 - Wednesday");
        System.out.println("5 - Thursday");
        System.out.println("6 - Friday");
        System.out.println("7 - Saturday");
        
        w = input.nextShort();
        
        return w;
}
    
    public static void main(String[] args){
        
        int i, j, d; 
        /* 
            i e j são indices para o array de funcionarios,
        d captura entradas de decisões. 
        */
        
        String c; 
        /*
            Captura o '/n' de alguns comandos anteriores a uma
        captura de string
        */
        
        int max = 100; // Tamanho do array
        
        int r; // Guardar o faturamento da empresa
        
        int k; // busca
        
        int p; // dia de pagamento
        
        double x; // Capturar o salário pago
                    
        double t; // Pegar uma taxa de serviço
        
        int day = 1; // Dia inicial, domingo    
        
        int friday; // tag para indicar se hoje é sexta-feira
        int f = 6; // Primeira sexta feira do mês
        int aux = 0; // Auxiliar para contar as sextas feiras
        
        int bonusComissoes = 0;
        
        Employee[] emp = new Employee[max]; // Array de funcionarios
        Employee[] copy = new Employee[max]; // Array cópia do array de funcionarios
        AppointmentBook [] books = new AppointmentBook[30]; // Array das agendas de pagamento

        Scanner input  = new Scanner(System.in);
  
        for(i = 0; i < 100; i++){
            emp[i] = new Employee();
            copy[i] = new Employee();
            if(i < 30){
                books[i] = new AppointmentBook();
            }
        }
        
        books[0].type = "Weekly"; // Semanalmente
        books[0].weekday = 6; // Sexta-feira
        
        books[1].type = "Monthly"; // Mensalmente
        books[1].payday = 15; 
        
        books[2].type = "Bi-weekly"; // Bi-semanalmente
        books[0].weekday = 6; // Sexta-feira
       
        int booksTypes = 3; // Índice para o número atual de agendas 
        
        // TESTS
        
        emp[0].name = "John Locke";
        emp[0].address = "Lost Island";
        emp[0].syndicate = 1; // Pertence ao sindicato
        emp[0].unionFee = 0.05; // Taxa sindical a ser descontada
        emp[0].type = 2; // Assalariado
        emp[0].appBook = 2; // Agenda tipo 2 - Mensalmente
        emp[0].payment = 3; // Check enviado por correios
        emp[0].payday = 15; // Dia do mês a receber
        emp[0].workHoursTotal = 160; // Horas trabalhadas
        emp[0].salary = (3000.00 * (1 - emp[0].unionFee)); // Salário mensal
        emp[0].id = 1; // Número de identificação
        
        emp[1].name = "Nemo";
        emp[1].address = "P. Sherman, 42 Wallaby Way, Sydney";
        emp[1].syndicate = 2; // Não pertence ao sindicato
        emp[1].type = 1; // Horista
        emp[1].appBook = 1; // Agenda tipo 1 - Semanalmente
        emp[1].perHour = 20; // Receber R$ 20,00 por hora trabalhada 
        emp[1].payment = 3; // Check enviado por correios
        emp[1].workHoursTotal = 80; // Horas Totais trabalhadas
        emp[1].salary = (emp[1].workHoursTotal * emp[1].perHour);
        /* 
            Salário calculado em função das horas trabalhadas
        vezes uma taxa de R$ 20,00
        */
        emp[1].id = 2; // Número de identificação
        
        emp[2].name = "Ted Mosby";
        emp[2].address = "Maclaren's Pub, New York City";
        emp[2].syndicate = 1; // Pertence ao sindicato
        emp[2].unionFee = 0.05; // Taxa sindical a ser descontada
        emp[2].type = 3; // Comissionado
        emp[2].perCom = 0.10; // Taxa a ser aplicada sobre um resultado de venda
        emp[2].payment = 3; // Check enviado por correios
        emp[2].appBook = 3; // Agenda tipo 3 - Bi-semanalmente
        emp[2].salary = 3000; 
        /*
            O salário de um comissionado é calculado da seguinte forma:
                salário = salário fixo + comissões
        */
        emp[2].id = 3; // Número de identificação
       
        i = 4; // Controle do número de empregados
        
        short n;
       
        do{
            
            System.out.println("------------- RoboVision 2000 -------------");
            
            System.out.println("Please, insert the number of your action:");
            System.out.println("1 - Add a new employee");
            System.out.println("2 - Remove an employee");
            System.out.println("3 - Punch the clock");
            System.out.println("4 - Launch a new Sold Result");
            System.out.println("5 - Launch a Service Charge");
            System.out.println("6 - Change some details of a new an employee");
            System.out.println("7 - Play the Payroll");
            System.out.println("8 - Undo / Redo");
            System.out.println("9 - To Choose a payment schedule");
            System.out.println("10 - Create a new Appointment Book");     
            System.out.println("0 - Exit");
            
            friday = isFriday(day, f);
                if(friday == 1){
                    System.out.println("                             Sexta-feira! (" + day + ")");
                    aux++;
                        if(aux > 4){ // Controle das sextas-feiras do mês
                            aux = 0;
                        }
                }
                else{
                    System.out.println("                                     day: " + day);
                }
                
            n = input.nextShort(); // Captura a ação desejada
            c = input.nextLine(); // Pegando /n do ultimo scanner
            
            if(n < 8){ // Salvar o status do array de funcionarios para um possível undo
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
                        System.out.println("Do you really wanna remove " + emp[j].name + "?");
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
                    
                    System.out.println("What day is today?");
                    
                    day = input.nextInt();
                    
                    System.out.println(emp[j].name);
                    System.out.println("Are you arriving?");
                    System.out.println("1 - Yes");
                    System.out.println("2 - No");
                    
                    d = input.nextInt();
                    
                        if(d == 1){
                            System.out.println("What time is it? (Only Hours*)");
                            emp[j].hourArrive = input.nextInt();
                        }
                        else{
                            System.out.println("Are you leaving?");
                            System.out.println("1 - Yes");
                            System.out.println("2 - No");
                            d = input.nextInt();
                                if(d == 1){
                                    System.out.println("What time is it? (Only Hours*)");
                                    emp[j].hourLeave = input.nextInt();
                                    emp[j].workHoursToday = (emp[j].hourLeave - emp[j].hourArrive);
                                    System.out.println(emp[j].workHoursToday + " hrs did you worked today!");
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
                            emp[j].bonusCom += r;
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
                    p = input.nextInt();
                    
                    for(k = 0; k < i; k++){
                          
                        switch (emp[k].type) {
                            case 1:
                                // HORISTA
                                
                                x = weekday();// Descobrir que dia da semana é hoje
                                
                                if(emp[k].appBook != 3 || books[emp[k].appBook].weekday == x){
                                    x = (emp[k].workHoursTotal * emp[k].perHour);
                                    if(emp[k].syndicate == 1){
                                        x *= (1 - emp[k].unionFee);
                                    }
                                    if(emp[k].incomeService > 0){
                                        x *= (1 - emp[k].incomeService);
                                    }
                                    System.out.println(emp[k].name + " recebeu " + x);
                                 }
                                
                                break;
                                
                            case 2:
                                // MENSAL
                                x = emp[k].salary;
                                if(emp[k].payday == p){
                                    if(emp[k].syndicate == 1){
                                        x *= (1 - emp[k].unionFee);
                                    }
                                    if(emp[k].incomeService > 0){
                                        x *= (1 - emp[k].incomeService);
                                    }
                                    System.out.println(emp[k].name + " recebeu " + x);
                                }
                                
                                break;
                            
                            case 3:
                                // COMISSIONADO
                                if(friday == 1 && aux == 2){ // DUAS SEXTAS FEIRAS
                                    x = emp[k].salary + emp[k].bonusCom;
                                    if(emp[k].incomeService > 0){
                                        x *= (1 - emp[k].incomeService);
                                    }
                                    System.out.println(emp[k].name + " recebeu " + x);
                                    emp[k].bonusCom = 0;
                                }
                                
                                break;
                            
                            default:
                                break;
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
                    
                    for(k = 0; k < booksTypes; k++){
                        System.out.println(k+1 + " - " + books[k].type);
                    }
                    
                    d = input.nextInt();
                    
                    emp[j].appBook = d;
                    
                    System.out.println(books[d-1].type + " way choosed!");
                    
                    break;
                
                case 10:
                    
                    System.out.println("Let's create a new Appointment books");
                    System.out.println("Choose a name:");
                    books[booksTypes].type = input.nextLine();
                    System.out.println("Based on what options?");
                    System.out.println("1 - Day(s) in a month");
                    System.out.println("2 - Weekday(s) in a week");
                    d = input.nextInt();
                        
                        switch(d){
                            
                            case 1:
                            
                                System.out.println("Please insert a day:");
                                p = input.nextInt();
                                books[booksTypes].payday = p;
                                System.out.println("Done!");
                                System.out.println(books[booksTypes].type + " " + p + " was created!");
                                booksTypes++;
                            
                            break;
                    
                            case 2:
                                
                                p = weekday();
                                books[booksTypes].weekday = p;
                                System.out.println("Done!");
                                System.out.println(books[booksTypes].type + " " + p + " was created!");
                                booksTypes++;
                            
                            default:
                            
                            break;
                         }
                    
                    break;
                
                default:
                    System.out.println("Invalid Number, please try again");
                    break;
            }
            
            System.out.print("\n");
            
        }while(n != 0);
    }   
}