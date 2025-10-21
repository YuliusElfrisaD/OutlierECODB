# Outlier ECODB

[![Java](https://img.shields.io/badge/Language-Java-orange?style=flat-square&logo=java)](https://www.java.com)
[![Platform](https://img.shields.io/badge/Platform-Desktop-blue?style=flat-square&logo=windows)]()
[![Framework](https://img.shields.io/badge/Framework-Java%20Swing-green?style=flat-square)]()
[![License](https://img.shields.io/badge/License-Academic-lightgrey?style=flat-square)]

---

## 📌 Overview  
**Outlier ECODB** is a desktop-based application built with **Java Swing** that implements the **Enhanced Class Outlier Distance Based (ECODB)** algorithm to detect outliers in educational evaluation datasets.  
The dataset was obtained from the **Quality Assurance and Internal Audit Office of a university**, containing information such as lecturer names, courses, study programs, semesters, and evaluation scores.  

This application was developed as part of an undergraduate research project to evaluate the performance of the ECODB algorithm in detecting anomalous records within academic evaluation data.  
The results confirmed that ECODB successfully detected **six outlier records** from the 2016–2017 dataset.

---

## 🚀 Features  
- Desktop-based interface built with **Java Swing**  
- Implementation of the **Enhanced Class Outlier Distance Based (ECODB)** algorithm  
- Supports dataset import (e.g., CSV format)  
- Customizable algorithm parameters:  
  - **K** → Number of nearest neighbors  
  - **N** → Number of subsets in dataset  
- Displays outlier detection results within the GUI  
- Option to export analysis results for further review  

---

## 🛠️ Tech Stack  
| Component | Description |
|------------|-------------|
| **Language** | Java |
| **Framework** | Java Swing |
| **Algorithm** | Enhanced Class Outlier Distance Based (ECODB) |
| **Platform** | Desktop |
| **Dataset** | Educational evaluation data (2016–2017) |

---

## 🏁 Getting Started  

### 1. Clone the Repository  
```bash
git clone https://github.com/YuliusElfrisaD/OutlierECODB.git
cd OutlierECODB
```

---

2. Open the Project

Open the folder using your preferred Java IDE (e.g., IntelliJ IDEA or Eclipse).

---

3. Configure Settings

Place your dataset (e.g., evaluation_data.csv) in the project directory.

Adjust ECODB parameters (K, N) in the configuration or code as needed.

---

4. Run the Application

Execute the Main class to launch the Swing-based GUI.
Load the dataset and run the ECODB algorithm to identify outliers.

---

5. View and Export Results

Detected outliers will be displayed within the application interface.
Results can optionally be exported for documentation or further statistical analysis.

---

📚 Research Reference

This application is based on the undergraduate thesis:

“Evaluation of Learning Using ECODB Algorithm on Learning Evaluation Data — 2016/2017”
Sanata Dharma University

---

🗂 Repository Structure
OutlierECODB/
├── src/                  # Java source files
├── data/                 # Input datasets (e.g., CSV)
├── output/               # Analysis results and exports
├── lib/                  # External libraries if needed
├── README.md
└── ...                   # Config or UI files

---

📄 License

This project was created for academic research purposes.
© 2019 — Yulius Elfrisa Desancoko
Unauthorized redistribution or commercial use is prohibited.

