package CommandInterface;

import Sort.SortArray;

import java.util.Scanner;

public class Command  {
    public Command(){

        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  Sorting Algorithms");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

        Scanner cli = new Scanner(System.in);
        SortArray sort;
        while (true) {
            System.out.println("please enter the file path: ");
            String filePath = cli.nextLine();
            try {
                sort = new SortArray(filePath);
                break;
            } catch (Throwable t) {}
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tMain Menu\n");
        while (true){
            System.out.println("\nchoose one of the following sorting techniques:-");
            System.out.println("1- Simple Sort");
            System.out.println("2- Efficient Sort");
            System.out.println("3- Non-Comparison Sort");
            System.out.println("4- Exit");
            System.out.println("enter your answer (1/2/3/4): ");

            String intermediate, mainMenuChoice = cli.nextLine();
            int[][] results;
            if(mainMenuChoice.equals("1")){
                while (true){
                    System.out.print("please enter if you want intermediate results (1) or not (0): ");
                    intermediate = cli.nextLine();
                    if(intermediate.equals("0")){
                        results = sort.SimpleSort(false);
                    }else if(intermediate.equals("1")){
                        results = sort.SimpleSort(true);
                    }else{
                        System.out.println("wrong input!!!!");
                        continue;
                    }
                    break;
                }
                System.out.println("the result:");
                for(int i = 0; i < results.length; i++){
                    for(int j = 0; j < results[0].length; j++){
                        System.out.print(results[i][j]);
                        if(j != results[0].length - 1) System.out.print(" ,");
                        else System.out.println();
                    }
                }
            }else if(mainMenuChoice.equals("2")) {
                System.out.print("please enter merge sort (1) or heap sort (2): ");
                String algo = cli.nextLine();
                while (true){
                    if(algo.equals("1")){
                        while (true){
                            System.out.print("please enter if you want intermediate results (1) or not (0): ");
                            intermediate = cli.nextLine();
                            if(intermediate.equals("0")){
                                results = sort.efficientSort(false);
                            }else if(intermediate.equals("1")){
                                results = sort.efficientSort(true);
                            }else{
                                System.out.println("wrong input!!!!");
                                continue;
                            }
                            break;
                        }
                        System.out.println("the result:");
                        for(int i = 0; i < results.length; i++){
                            for(int j = 0; j < results[0].length; j++){
                                System.out.print(results[i][j]);
                                if(j != results[0].length - 1) System.out.print(" ,");
                                else System.out.println();
                            }
                        }
                    }else if(algo.equals("2")){
                        //here call the heap sort and store it in the 2d array results
                    }else{
                        System.out.println("wrong input!!!!");
                        continue;
                    }
                    break;
                }

            }else if(mainMenuChoice.equals("3")){
                while (true){
                    System.out.print("please enter if you want intermediate results (1) or not (0): ");
                    intermediate = cli.nextLine();
                    if(intermediate.equals("0")){
                        //here call the count sort
//                        results = sort.SimpleSort(false);
                    }else if(intermediate.equals("1")){
                        //here call the count sort
//                        results = sort.SimpleSort(true);
                    }else{
                        System.out.println("wrong input!!!!");
                        continue;
                    }
                    break;
                }
            }else if(mainMenuChoice.equals("4")){
                break;
            }else{
                System.out.println("please enter a correct input!!");
                continue;
            }
            break;

        }

    }



}


