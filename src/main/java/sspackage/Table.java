package sspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table extends SearchPageWithResults{


    private WebElement tableElement;
    private WebDriver driver;

    public Table(WebElement tableElement, WebDriver driver) {
        super();
        this.tableElement = tableElement;
        this.driver = driver;
    }

    public Table(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getRows() {                                                                                 //Получаем все строки
        List<WebElement> rows = tableElement.findElements(By.xpath("//table[@id='page_main']//table[2]//tr"));
        rows.remove(0);
        return rows;
    }

    public List<WebElement> getHeadings(){                                                                              //Получаем заголовки
        WebElement headingsRow = tableElement.findElement(By.xpath("//table[@id='page_main']//table[2]//tr[1]"));
        List<WebElement> headingsColumns = headingsRow.findElements(By.xpath("//table[@id='page_main']//table[2]//tr[1]//td"));
        return headingsColumns;
    }

    public List<List<WebElement>> getRowsWithColumns(){                                                                 //Получаем отдельные столбци в строках
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for (WebElement row : rows){
            List<WebElement> rowWithColumns = row.findElements(By.xpath("//td[@class='msga2 pp0']"));
            rowsWithColumns.add(rowWithColumns);

            System.out.println(rowsWithColumns.size());
            //Разбитую строку на столци добавляем в новый список
        }
        return rowsWithColumns;                                                                                         //Получаем список строк разбитых на столбци
    }

    public String getValueFromCell(int rowNumber, int columnNumber){
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
        return cell.getText();
    }

    public String getValueFromCell(int rowNumber, String columnName){
       List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
       return rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName).getText();
    }

    public List<Map<String, WebElement>> getRowsWithColumnsByHeadings(){
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = new ArrayList<Map<String, WebElement>>();
        Map<String, WebElement> rowByHeadings;                                                                          // это одна строка расбитая на столбци расбитая по заголовку
        List<WebElement> headingColumns = getHeadings();                                                                //получим наши заголовки
        for (List<WebElement> row : rowsWithColumns){
            rowByHeadings = new HashMap<String, WebElement>();
            for(int i = 0; i < headingColumns.size(); i++){
                String heading = headingColumns.get(i).getText();
                WebElement cell = row.get(i);
                rowByHeadings.put(heading, cell);
            }
            rowsWithColumnsByHeadings.add(rowByHeadings);
        }
        return rowsWithColumnsByHeadings;
    }
}
