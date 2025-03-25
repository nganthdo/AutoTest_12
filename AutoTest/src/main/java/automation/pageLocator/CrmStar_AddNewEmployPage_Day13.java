package automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CrmStar_AddNewEmployPage_Day13 {
	private WebDriver driver;

	// FindBy for Add New Employee Form
	@FindBy(xpath = "//button[text()='Thêm mới']")
	WebElement btnAddNew;

	@FindBy(xpath = "//input[@name='username']")
	WebElement textFullName;
	@FindBy(xpath = "//input[@name='email']")
	WebElement textEmail;
	@FindBy(xpath = "//input[@name='phone_number']")
	WebElement textPhoneNumber;

	@FindBy(xpath = "//select[@id='select_department_id']")
	WebElement ddlDepartment;
	@FindBy(xpath = "//select[@id='select_role_id']")
	WebElement ddlRole;
	@FindBy(xpath = "//select[@id='select_workarea_id']")
	WebElement ddlWorkArea;

	@FindBy(xpath = "//input[@name='code_user']")
	WebElement textUserCode;

	@FindBy(xpath = "//button[@type = 'button' and text()='Lưu']")
	WebElement btnSave;

	@FindBy(xpath = "//button[@class = 'btn btn-success' and text()='Thêm']")
	WebElement btnConfirmAddNew;

	public CrmStar_AddNewEmployPage_Day13(WebDriver _driver) {

		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}

	public void AddNewEmployeeFunction(String fullname, String email, String phone, String department, String role,
			String workarea, String usercode) {

		btnAddNew.click();

		textFullName.clear();
		textFullName.sendKeys(fullname);

		textEmail.clear();
		textEmail.sendKeys(email);

		textPhoneNumber.clear();
		textPhoneNumber.sendKeys(phone);

		Select selectDepartment = new Select(ddlDepartment);
		selectDepartment.selectByContainsVisibleText(department);

		Select selectRole = new Select(ddlRole);
		selectRole.selectByContainsVisibleText(role);

		Select selectWorkArea = new Select(ddlWorkArea);
		selectWorkArea.selectByContainsVisibleText(workarea);

		textUserCode.clear();
		textUserCode.sendKeys(usercode);

		btnSave.click();

		btnConfirmAddNew.click();

	}

}
