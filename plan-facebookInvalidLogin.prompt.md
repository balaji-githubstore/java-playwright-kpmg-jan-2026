## Plan: Automate Facebook Invalid Login Test

This plan outlines how to automate a test that navigates to Facebook, enters invalid credentials, and clicks the Login button. The goal is to verify the application's response to invalid login attempts, likely using Playwright with Java based on your workspace structure.

### Steps
1. Identify or create a test class (e.g., `FacebookLoginTest`) in [src/test/java/...](D:\Mine\Company\KPMG Jan 2026\Project\java-playwright-kpmg-jan-2026\src\test\java\).
2. Set up a Playwright test method to open https://www.facebook.com/.
3. Locate and fill the email and password fields with invalid data.
4. Locate and click the Login button.
5. Optionally, assert the presence of an error message or failed login indicator.

### Further Considerations
1. Should the test be data-driven for multiple invalid credentials?
2. Should the test include assertions for specific error messages?
3. Confirm which framework (JUnit/TestNG/Cucumber) to use for the test structure.
