import java.sql.SQLException;
import java.sql.ResultSet;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.File;



public class ExcelUtility
{
    public static String read(final String name, final int rownum, final int column) throws IOException {
        final FileInputStream file = new FileInputStream(new File("src//main//resources//yash.xlsx"));
        final XSSFWorkbook workbook = new XSSFWorkbook((InputStream)file);
        final Sheet sheet = (Sheet)workbook.getSheet(name);
        final Row row = sheet.getRow(rownum);
        return row.getCell(column).getStringCellValue();
    }
    
    public static void write(final String name, final int rownum, final int column) throws IOException {
        final XSSFWorkbook workbook = new XSSFWorkbook();
        final Sheet sheet = (Sheet)workbook.createSheet("abd");
        final Row row = sheet.createRow(rownum);
        row.createCell(column).setCellValue(name);
        final FileOutputStream file = new FileOutputStream(new File("src//main//resources//ysh.xlsx"));
        workbook.write((OutputStream)file);
        workbook.close();
    }
    
    public static void update(final String name, final int rownum, final int column) throws IOException {
        final FileInputStream file = new FileInputStream(new File("src//main//resources//ysh.xlsx"));
        final XSSFWorkbook workbook = new XSSFWorkbook((InputStream)file);
        final Sheet sheet = (Sheet)workbook.getSheet("abd");
        final Row row = sheet.createRow(rownum);
        row.createCell(column).setCellValue(name);
        final FileOutputStream files = new FileOutputStream(new File("src//main//resources//ysh.xlsx"));
        workbook.write((OutputStream)files);
        workbook.close();
    }
    
    public static void writeDB(final ResultSet rs) throws IOException, SQLException {
        final int num = rs.getMetaData().getColumnCount();
        final XSSFWorkbook workbook = new XSSFWorkbook();
        final Sheet sheet = (Sheet)workbook.createSheet("db");
        while (rs.next()) {
            final Row row = sheet.createRow(rs.getRow() - 1);
            for (int i = 1; i < num; ++i) {
                System.out.println(rs.getObject(i).toString());
                row.createCell(i - 1).setCellValue(rs.getObject(i).toString());
            }
        }
        final FileOutputStream file = new FileOutputStream(new File("src//main//resources//ysh.xlsx"));
        workbook.write((OutputStream)file);
        workbook.close();
    }
    
    public static void main(final String[] args) throws IOException, ClassNotFoundException, SQLException {
        writeDB(MySqlConnection.getConnection());
    }
}
