package com.piglin.testing;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );

        try
        {
            FileInputStream file = new FileInputStream(new File("Data.xlsx"));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            double[][] values = new double[109][11];
            String[] names = new String[11];

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell;
            for (int j=0;j<11;j++)
            {
                cell = cellIterator.next();
                //Check the cell type and format accordingly

                names[j] = cell.getStringCellValue();
            }
            for (int i=0;i<109;i++)
            {
                row = rowIterator.next();
                //For each row, iterate through all the columns
                cellIterator = row.cellIterator();



                for (int j=0;j<11;j++)
                {
                    cell = cellIterator.next();
                    //Check the cell type and format accordingly

                    values[i][j] = cell.getNumericCellValue();
                }
                System.out.println("");
            }
            file.close();

            for (int j=0;j<11;j++)
            {
                System.out.print(names[j]+",");
            }
            System.out.println();
            for (int i = 0; i < 109; i++) {
                for (int j = 0; j < 11; j++) {
                    System.out.print(values[i][j]+",");
                }
                System.out.println();
            }

            int maxIndex = 1;

            double result;
            double[][] best = new double[100][maxIndex+1];
            double[][] worst = new double[100][maxIndex+1];

            for (int i = -1; i < maxIndex; i++) {
                for (int j = -1; j < maxIndex; j++) {
                    for (int k = -1; k < maxIndex; k++) {
                        for (int l = -1; l < maxIndex; l++) {
                            for (int m = -1; m < maxIndex; m++) {
                                for (int n = -1; n < maxIndex; n++) {
                                    for (int o = -1; o < maxIndex; o++) {
                                        for (int p = -1; p < maxIndex; p++) {
                                            for (int q = -1; q < maxIndex; q++) {
                                                for (int r = -1; r < maxIndex; r++) {
                                                    for (int s = -1; s < maxIndex; s++) {
                                                        result = calculateRegression(values,i,j,k,l,m,n,o,p,q,r,s);
                                                        checkBest(best, result,i,j,k,l,m,n,o,p,q,r,s);
                                                        checkWorst(worst, result,i,j,k,l,m,n,o,p,q,r,s);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("BEST");
            for (int i=0;i<100;i++) {
                for (int j = 0; j < best.length; j++) {
                    System.out.print(best[i][j] + ",");
                }
                System.out.println();;
            }
            System.out.println();
            System.out.println("WORST")
            for (int i=0;i<100;i++) {
                for (int j = 0; j < worst.length; j++) {
                    System.out.print(worst[i][j] + ",");
                }
                System.out.println();;
            }
            System.out.println();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private static void checkWorst(double[][] worst, double result, int i, int j, int k, int l, int m, int n, int o, int p, int q, int r, int s) {
        for (int x = 0; x < worst.length; x++) {
            if (result>worst[x][0]) {
                if (result<=worst[x+1][0]) {
                    worst[x][0]=result;
                    worst[x][1]=i;
                    worst[x][2]=j;
                    worst[x][3]=k;
                    worst[x][4]=l;
                    worst[x][5]=m;
                    worst[x][6]=n;
                    worst[x][7]=o;
                    worst[x][8]=p;
                    worst[x][9]=q;
                    worst[x][10]=r;
                    worst[x][11]=s;
                    break;
                } else {
                    continue;
                }
            } else if (result<=worst[x][0]) {
                break;
            }
        }
    }

    private static void checkBest(double[][] best, double result, int i, int j, int k, int l, int m, int n, int o, int p, int q, int r, int s) {
        for (int x = 0; x > best.length; x++) {
            if (result<best[x][0]) {
                if (result>=best[x+1][0]) {
                    best[x][0]=result;
                    best[x][1]=i;
                    best[x][2]=j;
                    best[x][3]=k;
                    best[x][4]=l;
                    best[x][5]=m;
                    best[x][6]=n;
                    best[x][7]=o;
                    best[x][8]=p;
                    best[x][9]=q;
                    best[x][10]=r;
                    best[x][11]=s;
                    break;
                } else {
                    continue;
                }
            } else if (result>=best[x][0]) {
                break;
            }
        }
    }

    private static double calculateRegression(double[][] values, int i, int j, int k, int l, int m, int n, int o, int p, int q, int r, int s) {
        return 0;
    }
}
