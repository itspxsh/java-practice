# 📚 Java Algorithm Practice

Practice code for algorithm problems.

## 📂 Project Structure

This project uses a `src` (source) and `bin` (compiled) structure.

cd Desktop
mkdir MyExamCode
cd MyExamCode

MyExamCode/
├── src/
│   └── th/
│       └── ac/
│           └── kmutt/
│               └── cpe/
│                   └── algorithm/
│                       └── pawarisa/
│                           ├── HistogramSelect.java
│                           └── Sand.java
├── bin/
│   └── (Empty, for compiled files)
│
└── TestCase/
    ├── testOne/
    │   ├── in1.txt
    │   ├── ...
    │   └── in10.txt
    └── testTwo/
        ├── in1.txt
        ├── ...
        └── bonus2.txt

cd Desktop/MyExamCode



## 🛠️ How to Use

All commands are run from the project's root folder (`MyExamCode`).

### 1. Compile

To compile all `.java` files from `src` into the `bin` folder:
To run a specific problem, use the java -cp bin command and feed in a test case using <.:

```bash
javac -d bin -sourcepath src src/th/ac/kmutt/cpe/algorithm/pawarisa/*.java

java -cp bin <package.name.ClassName> < TestCase/path/to/input.txt

java -cp bin th.ac.kmutt.cpe.algorithm.pawarisa.HistogramSelect < TestCase/testOne/in1.txt

java -cp bin th.ac.kmutt.cpe.algorithm.pawarisa.Sand < TestCase/testTwo/in1.txt ```
