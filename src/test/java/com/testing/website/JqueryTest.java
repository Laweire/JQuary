package com.testing.website;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryTest {

	public WebDriver driver;

	@BeforeClass 
	public void openWebdriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@BeforeMethod
	public void openWebsite() {
		String url = "https://jqueryui.com/";
		driver.get(url);

	}

	@AfterClass
	public void closing() {
		if (driver != null) {
			driver.close();
		}

	}


	@Test(priority=0)
	public void draggable() throws InterruptedException {
		
		WebElement dragbblebtn = driver.findElement(By.linkText("Draggable"));
		dragbblebtn.click();

		Thread.sleep(2 * 1000);

		driver.switchTo().frame(0);

		Actions drag = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		drag.dragAndDropBy(source, 150, 150).build().perform();

		driver.switchTo().defaultContent();

	}

	@Test(priority=1)
	public void droppable() throws InterruptedException {
		
		WebElement dpbbtn = driver.findElement(By.linkText("Droppable"));
		dpbbtn.click();

		driver.switchTo().frame(0);

		Actions dragndrop = new Actions(driver);
		WebElement source1 = driver.findElement(By.id("draggable"));
		WebElement target1 = driver.findElement(By.id("droppable"));
		dragndrop.dragAndDrop(source1, target1).build().perform();

		driver.switchTo().defaultContent();

	}

	@Test(groups = {"interactions"}, priority=3)
	public void resizable() throws InterruptedException {
		WebElement rszbtn = driver.findElement(By.linkText("Resizable"));
		rszbtn.click();

		driver.switchTo().frame(0);

		Actions resize = new Actions(driver);
		WebElement source2 = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
		resize.clickAndHold(source2).moveToElement(source2, 70, 70).release().build().perform();
		Thread.sleep(2 * 1000);
		driver.switchTo().defaultContent();

	}

	@Test(groups = {"interactions"}, priority=4)
	public void select() throws InterruptedException {
		WebElement selectbtn = driver.findElement(By.linkText("Selectable"));
		selectbtn.click();

		driver.switchTo().frame(0);

		String head = "//*[@id='selectable']/li[";
		String tail = "]";

		for (int i = 2; i <= 7; i++) {
			String ele = head + i + tail;
			driver.findElement(By.xpath(ele)).click();
		}
		Thread.sleep(2 * 1000);

		driver.switchTo().defaultContent();
	}

	@Test(groups = {"interactions"}, priority=5)
	public void sorting() throws InterruptedException {
		
		WebElement sortingbtn = driver.findElement(By.linkText("Sortable"));
		sortingbtn.click();

		driver.switchTo().frame(0);

		Actions sortnb = new Actions(driver);

		WebElement one = driver.findElement(By.xpath("//*[@id='sortable']/li[1]"));
		WebElement two = driver.findElement(By.xpath("//*[@id='sortable']/li[2]"));
		WebElement three = driver.findElement(By.xpath("//*[@id='sortable']/li[3]"));
		WebElement four = driver.findElement(By.xpath("//*[@id='sortable']/li[4]"));
		WebElement five = driver.findElement(By.xpath("//*[@id='sortable']/li[5]"));
		WebElement six = driver.findElement(By.xpath("//*[@id='sortable']/li[6]"));
		WebElement seven = driver.findElement(By.xpath("//*[@id='sortable']/li[7]"));

		 sortnb.dragAndDrop(seven,one).build().perform();
		 sortnb.dragAndDrop(one, six).build().perform();
		 sortnb.dragAndDrop(six, two).build().perform();
		 sortnb.dragAndDrop(two, five).build().perform();
		 sortnb.dragAndDrop(five, three).build().perform();
		 sortnb.dragAndDrop(three, four).build().perform();
		
		
		Thread.sleep(6 * 1000);
		driver.switchTo().defaultContent();

	}

	@Test(groups = {"Widgets"}, priority=6)
	public void accordin() throws InterruptedException {
		WebElement accordinbtn = driver.findElement(By.linkText("Accordion"));
		accordinbtn.click();

		driver.switchTo().frame(0);
		WebElement sectionOne = driver.findElement(By.xpath("//*[@id='ui-id-1']/span"));
		sectionOne.click();

		WebElement sectionTwo = driver.findElement(By.xpath("//*[@id='ui-id-3']/span"));
		sectionTwo.click();
		WebElement sectionThree = driver.findElement(By.xpath("//*[@id='ui-id-5']/span"));
		sectionThree.click();
		WebElement sectionFour = driver.findElement(By.xpath("//*[@id='ui-id-7']/span"));
		sectionFour.click();
		driver.switchTo().defaultContent();

	}

	@Test(groups = {"Widgets"}, priority=7)
	public void autocomplete() throws InterruptedException {
		WebElement auto = driver.findElement(By.linkText("Autocomplete"));
		auto.click();

		driver.switchTo().frame(0);

		WebElement typetag = driver.findElement(By.id("tags"));
		typetag.sendKeys("ja");
		Select dropDown = new Select(typetag);
		dropDown.selectByIndex(0);

		Thread.sleep(2 * 1000);
		driver.switchTo().defaultContent();

	}

	@Test(groups ={"Widgets"}, priority=15)
	public void Button() throws InterruptedException {
		WebElement click1 = driver.findElement(By.linkText("Button"));
		click1.click();

		driver.switchTo().frame(0);

		WebElement btn1 = driver.findElement(By.xpath("/html/body/div/button"));
		btn1.click();

		WebElement btn2 = driver.findElement(By.xpath("/html/body/div/input"));
		btn2.click();

		WebElement btn3 = driver.findElement(By.xpath("/html/body/div/a"));
		btn3.click();

		Thread.sleep(2 * 1000);
		driver.switchTo().defaultContent();

	}

	@Test(groups = {"Widgets"}, priority=8)
	public void ClickRadio() throws InterruptedException {
		WebElement radiobtn = driver.findElement(By.linkText("Checkboxradio"));
		radiobtn.click();

		driver.switchTo().frame(0);

		String head = "/html/body/div/fieldset[";
		String number = "]/label[";
		String tail = "]";

		for (int i = 1; i <= 3; i++) {
			String Radio = head + "1" + number + i + tail;
			driver.findElement(By.xpath(Radio)).click();
		}

		Thread.sleep(2 * 1000);

		for (int i = 2; i <= 3; i++) {
			String sections = head + i + number;
			for (int z = 1; z <= 4; z++) {
				String buttons = z + tail;

				WebElement radio = driver.findElement(By.xpath(sections + buttons));
				radio.click();
				radio.click();
			
			}
		}
		driver.switchTo().defaultContent();

	}

	@Test(groups = {"Widgets"}, priority=9)
	public void Controlgroup() throws InterruptedException {
		WebElement controlbtn = driver.findElement(By.linkText("Controlgroup"));
		controlbtn.click();

		driver.switchTo().frame(0);
		
	
		for (int i=1;i<=7;i++){

			String rentaltype1="//*[@id='car-type-button']/span[1]";
			
			 driver.findElement(By.xpath(rentaltype1)).click();
		
			
			String begin="//*[@id='ui-id-";
			String end= "']";
			String cars= begin + i + end;
			driver.findElement(By.xpath(cars)).click();
			
		}
		int i=1;
		
		while(i<4){
			String lable1="/html/body/div[1]/fieldset[1]/div/label[";
			String lable2= "]";
			String slct= lable1 + i +lable2;
		WebElement standard= driver.findElement(By.xpath(slct));
		standard.click();
		
		i++;
		}
		
		for (int a=0;a<3;a++){
			String path= "/html/body/div[1]/fieldset[1]/div/span[2]/a[1]";
			WebElement up =driver.findElement(By.xpath(path));
			up.click();
		}
		Thread.sleep(1*1000);
			for (int z=0; z<2;z++){
				String path2= "/html/body/div[1]/fieldset[1]/div/span[2]/a[2]";
				WebElement down =driver.findElement(By.xpath(path2));
				down.click();
			}
			
			driver.findElement(By.xpath("/html/body/div[1]/fieldset[1]/div/button")).click();
		

			//second
						
				
			for (int z=9;z<=15;z++){

		String rentaltype2="//*[@id='ui-id-8-button']/span[2]";	
		driver.findElement(By.xpath(rentaltype2)).click();
		
		 
		String begin1="//*[@id='ui-id-";
		String end1= "']";
		String cars1= begin1 + z + end1;
		driver.findElement(By.xpath(cars1)).click();
		
	}
	int z=1;
	
	while(z<4){
		String lable3="/html/body/div[1]/fieldset[2]/div/label[";
		String lable4= "]";
		String slct2= lable3 + z +lable4;
	WebElement standard= driver.findElement(By.xpath(slct2));
	standard.click();
	
	z++;
	}
	
	for (int c=0;c<3;c++){
		String path3= "/html/body/div[1]/fieldset[2]/div/span[2]/a[1]";
		WebElement up =driver.findElement(By.xpath(path3));
		up.click();
	}
	
	Thread.sleep(1*1000);
		for (int t=0; t<2;t++){
			String path4= "/html/body/div[1]/fieldset[2]/div/span[2]/a[2]";
			WebElement down =driver.findElement(By.xpath(path4));
			down.click();
		}
		
		driver.findElement(By.id("book")).click();
	

		driver.switchTo().defaultContent();

			
		}
	
	@Test (groups = {"Widgets"}, priority=10)
	public void datetyper (){
		
		WebElement datebtn = driver.findElement(By.linkText("Datepicker"));
		datebtn.click();
		
		driver.switchTo().frame(0);
		
		WebElement date = driver.findElement(By.id("datepicker"));
		date.clear();
		date.sendKeys("06/19/1997");
		
	}

	@Test (groups = {"Widgets"}, priority=16)
	public void dialog () throws Exception{
		WebElement dialogbtn = driver.findElement(By.linkText("Dialog"));
		dialogbtn.click();
		
		driver.switchTo().frame(0);
		
		WebElement dialog= driver.findElement(By.xpath("/html/body/div/div[1]"));
		Actions action= new Actions(driver);
		action.dragAndDropBy(dialog, 100, 100);
		
		
		WebElement resize= driver.findElement(By.xpath("/html/body/div/div[7]"));
		Actions action2 = new Actions(driver);
		action2.dragAndDropBy(resize, 100, 100);
		Thread.sleep(2*1000);
		
		WebElement close = driver.findElement(By.xpath("/html/body/div/div[1]/button/span[1]"));
		close.click();
			
	}
	@Test (groups = {"menu"}, priority=17)
	public void Menu () throws Exception{
		
		WebElement Menubtn = driver.findElement(By.linkText("Menu"));
		Menubtn.click();
		
		driver.switchTo().frame(0);
			 
			String sub1="//*[@id='ui-id-";
					String sub2= "']";
			 Actions A=new Actions(driver);
			 for(int i=1;i<=16;i++){
				 String sub= sub1+i+sub2;
				 
			 A.moveToElement(driver.findElement(By.xpath(sub))).build().perform();
			
			
		}
		driver.switchTo().defaultContent();

		
	}
	
	@Test(groups = {"Widgets"}, priority=11)
	public void progressbar(){
		WebElement progressbtn = driver.findElement(By.linkText("Progressbar"));
		progressbtn.click();
		
		driver.switchTo().frame(0);
		
		WebElement bar = driver.findElement(By.xpath("//*[@id='progressbar']"));
		System.out.println("the size is:"+bar.getAttribute("aria-valuenow"));	
		driver.switchTo().defaultContent();

	}	
	

	@Test(groups = "Widgets", priority=20)
	public void selectmenu(){
		WebElement selectbtn = driver.findElement(By.linkText("Selectmenu"));
			selectbtn.click();
		
		driver.switchTo().frame(0);
		
		
		String first ="//*[@id='speed-menu']/li[";
		String second = "]";

		WebElement btn = driver.findElement(By.xpath("//*[@id='speed-button']/span"));
		btn.click();
		for (int i=1;i<5;i++){
			driver.findElement(By.xpath(first+ i+ second)).click(); 
			btn.click();
			
	
		}
		driver.switchTo().defaultContent();
	
	}
	
	@Test (groups = {"Widgets"}, priority=12)
	public void slider() throws Exception{
		WebElement sliderbtn = driver.findElement(By.linkText("Slider"));
			sliderbtn.click();
		
			WebElement colorbtn = driver.findElement(By.linkText("Colorpicker"));
			colorbtn.click();
		
			driver.switchTo().frame(0);
			WebElement red = driver.findElement(By.xpath("//*[@id='red']/span"));
			WebElement green = driver.findElement(By.xpath("//*[@id='green']/span"));
			WebElement blue = driver.findElement(By.xpath("//*[@id='blue']/span"));
			
			Actions slide = new Actions(driver);
			slide.dragAndDropBy(red, -400, 0);
			slide.dragAndDropBy(green, 0, 0);
			slide.click().dragAndDropBy(blue, 300, 0);
			Thread.sleep(2*1000);
			driver.switchTo().defaultContent();

}

	@Test (groups = {"Widgets"}, priority=13)
	public void spinner() throws Exception{
		WebElement spinnerbtn = driver.findElement(By.linkText("Spinner"));
			spinnerbtn.click();
	
			driver.switchTo().frame(0);
			WebElement valuedown=driver.findElement(By.xpath("/html/body/p[1]/span/a[1]/span[1]"));
			for(int i=0;i<7;i++){
			valuedown.click();
			}
			driver.findElement(By.xpath("//*[@id='getvalue']")).click();
			Alert alert=driver.switchTo().alert();
			alert.accept();
			driver.findElement(By.xpath("//*[@id='setvalue']")).click();
			
			Thread.sleep(1*1000);
			driver.switchTo().defaultContent();

				
	}
	@Test (groups = "Widgets",priority=19)
	public void Tabs() throws Exception{
		WebElement Tabsbtn = driver.findElement(By.linkText("Tabs"));
			Tabsbtn.click();
			
			driver.switchTo().frame(0);
			
			String tab1="//*[@id='ui-id-"; //*[@id="ui-id-1"]
			String tab2="']";
			
			for(int i=1;i<=3;i++){
				driver.findElement(By.xpath(tab1+i+tab2)).click();
			}
			
			driver.switchTo().defaultContent();

	}
	
	@Test (groups = {"Widgets"}, priority=18)
	public void Tooltip() throws Exception{
		WebElement Tooltipbtn = driver.findElement(By.linkText("Tooltip"));
			Tooltipbtn.click();
			
			driver.switchTo().frame(0);
			
			Actions move = new Actions(driver);
			WebElement text1=driver.findElement(By.xpath("//a[@href='#']"));

			move.moveToElement(text1).build().perform();
			Thread.sleep(1*1000);
			move.moveToElement(driver.findElement(By.xpath("//a[@href='http://jqueryui.com/themeroller/']"))).build().perform();
			Thread.sleep(1*1000);
			
			JavascriptExecutor jjs = (JavascriptExecutor) driver;
			jjs.executeScript("document.getElementById('age').value='23';");
			Thread.sleep(1*1000);
			driver.switchTo().defaultContent();

	}
	

	
	
	}