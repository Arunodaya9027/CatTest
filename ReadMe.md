# Shamir's Secret Sharing Simplified – Lagrange Interpolation

This project implements a simplified version of **Shamir's Secret Sharing** algorithm using **Lagrange interpolation** to compute the constant term `c` of a polynomial based on provided roots from a JSON file.  

## How to Clone and Run the Code

### 1. Clone the Repository  
First, clone the code from GitHub using the following command:  

```bash
git clone https://github.com/Arunodaya9027/CatTest
```

### 2. Open in **VSCode** or **IntelliJ IDEA**

- **VSCode:**
    1. Open VSCode.
    2. Click on **File > Open Folder** and select the folder where the code is cloned.
    3. Install the **Java Extension Pack** if not installed (it will prompt you).
    4. Ensure the JDK path is set correctly (Settings > Java > JDK).

- **IntelliJ IDEA:**
    1. Open IntelliJ IDEA.
    2. Select **Open** and choose the cloned folder.
    3. Ensure your **JDK** is correctly configured (File > Project Structure > SDKs).
    4. If required, enable **Maven** support.

### 3. Run the Code

1. Ensure you have the `test.json` file in the project directory (same folder as the `Main.java`).
2. Compile and run the code:

   - **VSCode:**  
     Use the `Run` button or press `Ctrl + F5` to run the project.

   - **IntelliJ IDEA:**  
     Right-click the `Main` class and select **Run 'Main.main()'**.

### 4. Output

The program will read from the provided testcases file and print the constant term `c` of the polynomial.
