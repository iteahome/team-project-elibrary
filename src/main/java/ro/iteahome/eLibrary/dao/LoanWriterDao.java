package ro.iteahome.eLibrary.dao;

import ro.iteahome.eLibrary.model.Book;

import java.io.*;
import java.sql.SQLOutput;
import java.util.List;


public class LoanWriterDao {

    private static final String LOANS_FILE = "/Users/cristianbalta/Desktop/team-project-elibrary/src/main/java/ro/iteahome/eLibrary/loans.txt";


    public int loaniddao = 0;
    public int loanuseriddao;
    public String loandatedao;
    public List<Book> bookListdao;

    public LoanWriterDao(int loanuseriddao, String loandatedao, List<Book> bookListdao) throws FileNotFoundException, IOException {

        this.loanuseriddao = loanuseriddao;
        this.loandatedao = loandatedao;
        this.bookListdao = bookListdao;


    }

    public void loanToFile() throws IOException {
        String lastLineIndex = null;
        FileReader reader = new FileReader(LOANS_FILE);
        BufferedReader br = new BufferedReader(reader);

        {
            String line = null;

            while ((line = br.readLine()) != null) {
                lastLineIndex = line.substring(0, 1);
            }


            loaniddao = Integer.parseInt(lastLineIndex);
        }
        br.close();

        FileWriter writer = new FileWriter(LOANS_FILE, true);
        BufferedWriter bw = new BufferedWriter(writer);

        {

            String loanToRegister = String.valueOf(loaniddao + 1) + "; " + loanuseriddao + "; " + loandatedao + "; " + bookListdao + "\n";

            bw.write(loanToRegister);
            System.out.println(loanToRegister);

        }
        bw.close();
    }


}




