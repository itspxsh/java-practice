package th.ac.kmutt.cpe.algorithm.pawarisa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StableMarriage {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        int[][] companyPrefs = new int[count][count];
        int[][] studentPrefs = new int[count][count]; 

        for (int r = 0; r < count; r++) {
            for (int c = 0; c < count; c++) {
                companyPrefs[r][c] = sc.nextInt();
            }
        }
        
        for (int r = 0; r < count; r++) {
            for (int c = 0; c < count; c++) {
                studentPrefs[r][c] = sc.nextInt();
            }
        }
        
        ArrayList<Integer> unmatchedStudents = new ArrayList<>();
        
        int[] companyPartner = new int[count]; 
        Arrays.fill(companyPartner, -1);

        for (int i = 0; i < count; i++) {
            unmatchedStudents.add(i); 
        }

        while (!unmatchedStudents.isEmpty()) {
            
            int currentStudent = unmatchedStudents.remove(0);
            int targetCompany = -1;

            for (int i = 0; i < count; i++) {
                if (studentPrefs[currentStudent][i] != -99) {
                    targetCompany = studentPrefs[currentStudent][i];
                    studentPrefs[currentStudent][i] = -99;
                    break;
                }
            }

            if (companyPartner[targetCompany] == -1) {
                companyPartner[targetCompany] = currentStudent;
            } else {
                int currentPartner = companyPartner[targetCompany];
                
                for (int i = 0; i < count; i++) {
                    
                    if (companyPrefs[targetCompany][i] == currentStudent) {
                        companyPartner[targetCompany] = currentStudent;
                        unmatchedStudents.add(currentPartner);
                        break;
                    } else if (companyPrefs[targetCompany][i] == currentPartner) {
                        unmatchedStudents.add(currentStudent);
                        break;
                    }
                }
            }
        }

        int[] studentAssignment = new int[count];
        for (int companyId = 0; companyId < count; companyId++) {
            int studentId = companyPartner[companyId];
            if (studentId != -1) {
                studentAssignment[studentId] = companyId;
            }
        }

        for (int studentId = 0; studentId < count; studentId++) {
            System.out.println(studentId + " " + studentAssignment[studentId]);
        }

        sc.close();
    }
}