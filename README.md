# Java Practice Repository

A comprehensive collection of Java programming exercises, algorithm problems, and coding challenges from various sources. This repository serves as a portfolio of problem-solving skills and Java proficiency.

## 📁 Repository Structure

```
java-practice/
├── leetcode/
│   ├── easy/
│   ├── medium/
│   ├── hard/
│   └── README.md
├── hackerrank/
│   ├── algorithms/
│   ├── data-structures/
│   └── README.md
├── labs/
│   ├── lab01/
│   ├── lab02/
│   └── README.md
├── codewars/
│   └── README.md
├── project-euler/
│   └── README.md
├── data/
│   ├── csv/
│   ├── txt/
│   └── README.md
├── utils/
│   └── Helper.java
├── .gitignore
└── README.md
```

### Folder Purposes

- **leetcode/**: LeetCode problems organized by difficulty (easy/medium/hard)
- **hackerrank/**: HackerRank challenges categorized by topic
- **labs/**: Academic lab assignments and course exercises
- **codewars/**: Codewars kata solutions
- **project-euler/**: Project Euler mathematical problems
- **data/**: Input data files (CSV, TXT, JSON) used across problems
- **utils/**: Reusable utility classes and helper functions

## 🚀 Getting Started

### Prerequisites

- Java JDK 11 or higher
- Git installed on your machine
- GitHub account

### Initial Setup

1. **Create a new repository on GitHub**
   - Go to https://github.com/new
   - Name it `java-practice` (or your preferred name)
   - Choose public or private
   - **DO NOT** initialize with README (we'll push our own)
   - Click "Create repository"

2. **Clone the repository to your local machine**
   ```bash
   git clone https://github.com/YOUR_USERNAME/java-practice.git
   cd java-practice
   ```

3. **Create the folder structure**
   ```bash
   mkdir -p leetcode/{easy,medium,hard}
   mkdir -p hackerrank/{algorithms,data-structures}
   mkdir -p labs
   mkdir -p codewars
   mkdir -p project-euler
   mkdir -p data/{csv,txt}
   mkdir -p utils
   ```

4. **Create a .gitignore file**
   ```bash
   cat > .gitignore << 'EOF'
   # Compiled class files
   *.class

   # Log files
   *.log

   # Package Files
   *.jar
   *.war
   *.nar
   *.ear
   *.zip
   *.tar.gz
   *.rar

   # IDE-specific files
   .idea/
   .vscode/
   *.iml
   *.iws
   *.ipr
   .DS_Store

   # Eclipse
   .classpath
   .project
   .settings/

   # Build directories
   target/
   build/
   out/
   bin/

   # Temporary files
   *.swp
   *.swo
   *~
   EOF
   ```

5. **Create this README file**
   - Copy this entire content into `README.md`

6. **Initial commit and push**
   ```bash
   git add .
   git commit -m "Initial repository setup with folder structure"
   git push -u origin main
   ```

   *Note: If your default branch is `master` instead of `main`, use `master` in the command above.*

## 📝 Daily Workflow

### Adding a New Solution

1. **Navigate to the appropriate folder**
   ```bash
   cd leetcode/easy
   ```

2. **Create your Java file**
   - Name format: `Problem001_TwoSum.java` or `TwoSum.java`
   - Include problem description in comments at the top

3. **Write your solution**
   ```java
   /**
    * Problem: Two Sum
    * Source: LeetCode #1
    * Difficulty: Easy
    * Link: https://leetcode.com/problems/two-sum/
    * 
    * Description:
    * Given an array of integers nums and an integer target,
    * return indices of the two numbers that add up to target.
    */
   public class TwoSum {
       public int[] twoSum(int[] nums, int target) {
           // Your solution here
       }
       
       public static void main(String[] args) {
           // Test cases
       }
   }
   ```

4. **Test your solution locally**
   ```bash
   javac TwoSum.java
   java TwoSum
   ```

5. **Stage and commit your changes**
   ```bash
   git add .
   git commit -m "Add LeetCode #1 - Two Sum solution"
   ```

6. **Push to GitHub**
   ```bash
   git push
   ```

### Working with Data Files

When a problem requires CSV or other input files:

1. **Add the data file to the data folder**
   ```bash
   cp ~/Downloads/input.csv data/csv/leetcode_problem123_input.csv
   ```

2. **Reference it in your Java code**
   ```java
   String filePath = "../../data/csv/leetcode_problem123_input.csv";
   ```

3. **Commit both the code and data**
   ```bash
   git add leetcode/medium/Problem123.java
   git add data/csv/leetcode_problem123_input.csv
   git commit -m "Add LeetCode #123 with CSV input data"
   git push
   ```

## 🔄 Git Commands Reference

### Basic Commands

```bash
# Check status of your repository
git status

# Add all changes
git add .

# Add specific file
git add path/to/file.java

# Commit with message
git commit -m "Your descriptive message"

# Push to GitHub
git push

# Pull latest changes
git pull

# View commit history
git log --oneline
```

### Branch Management (Optional for Advanced Practice)

```bash
# Create and switch to new branch
git checkout -b feature/new-problem

# Switch back to main branch
git checkout main

# Merge branch into main
git merge feature/new-problem

# Delete branch after merge
git branch -d feature/new-problem
```

## 📋 Best Practices

### Code Organization

1. **One problem per file** - Keep solutions isolated
2. **Descriptive naming** - Use clear, meaningful names
3. **Include problem metadata** - Add source, difficulty, and link in comments
4. **Write test cases** - Include `main()` method with test cases
5. **Document complexity** - Note time and space complexity

### Commit Message Conventions

```
Add [Source] #[Number] - [Problem Name]
Update [Source] #[Number] - [Improvement description]
Fix [Source] #[Number] - [Bug description]
Refactor [Source] #[Number] - [Refactoring description]
```

Examples:
- `Add LeetCode #217 - Contains Duplicate`
- `Update HackerRank - Improve time complexity for sorting problem`
- `Fix Lab03 - Correct edge case handling`

### File Naming Conventions

- **LeetCode**: `LC001_TwoSum.java` or `TwoSum.java`
- **HackerRank**: `HR_SortingAlgorithm.java`
- **Labs**: `Lab01_Exercise01.java`
- **Data files**: `problem_name_input.csv`

## 🎯 Goals

- ✅ Solve at least 3-5 problems per week
- ✅ Cover all difficulty levels
- ✅ Practice different algorithmic patterns
- ✅ Build a strong portfolio of solutions
- ✅ Regular commits to maintain GitHub streak

## 📊 Progress Tracking

Create a `PROGRESS.md` file to track your journey:

```markdown
# Progress Tracker

## Statistics
- Total Problems Solved: X
- LeetCode: X (Easy: X, Medium: X, Hard: X)
- HackerRank: X
- Labs: X

## Current Focus
- Topic: [e.g., Dynamic Programming]
- Goal: [e.g., Solve 10 DP problems this week]
```

## 🤝 Contributing

This is a personal practice repository, but if you'd like to share it:
1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Open a Pull Request

## 📄 License

This repository is for educational purposes. Problem descriptions are property of their respective platforms.

## 🔗 Resources

- [LeetCode](https://leetcode.com/)
- [HackerRank](https://hackerrank.com/)
- [Codewars](https://codewars.com/)
- [Project Euler](https://projecteuler.net/)
- [Java Documentation](https://docs.oracle.com/en/java/)

---

**Happy Coding! 🚀**
