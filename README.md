# 📦 Java Swing Marketing Packs

An enterprise-grade desktop application built with Java Swing for B2B commercial branches to evaluate, customize, and generate real-time budget analytics for corporate marketing campaigns.

## 🚀 Key Features

* **State-Driven Workflow Pipeline:** Implements a strict step-by-step validation workflow that isolates client profiling from campaign configuration to safeguard input integrity.
* **Dynamic Budget Evaluation Engine:** Custom pricing matrix logic applying dynamic multipliers based on company lifetime data, company tier categorization, and targeted distribution channels.
* **Granular Business Rule Validation:** Embedded exception interceptors providing immediate, contextual visual alerts upon business boundary breaches (e.g., negative parameters or discount overflow).
* **Robust Swing Architecture:** Clean layout structure utilizing standard layout alignment strategies, isolated input state utility helpers, and decoupled presentation logic.

## 🛠️ Tech Stack

* **GUI Framework:** Java Swing / AWT
* **Language:** Java 17+
* **Build Tool:** Maven

## 📦 Installation & Setup

1. Clone the repository:

```bash
git clone https://github.com/giiisyyy/java-swing-marketing-packs.git
```

```bash
cd java-swing-marketing-packs
```

2. Compile and package the executable infrastructure:

```bash
mvn clean package
```

3. Run the desktop application locally:

```bash
java -cp target/marketing-packs-manager-1.0.0.jar marketing.PacksMarketing
```

## 🧮 Calculation Logic

The application calculates the final budget based on the following business rules:

### 1) Base Price
* **Basic:** 200 €
* **Standard:** 450 €
* **Full:** 800 €
* **Premium:** 1200 €

### 2) Multipliers
* **Company Lifetime:**
  * If >= 10 years: 0.9 factor (10% discount).
  * If < 10 years: 1.0 factor.

* **Business Type:**
  * Freelancer (Autònom): 0.8 factor.
  * SME (PIME): 1.0 factor.
  * Large Enterprise: 1.2 factor.

### 3) Add-ons
* **Social Media (XXSS):** +150 €

* **SEM Advertising:** +250 €

### 4) Final Formula

```text
1. servicePrice = basePrice * lifetimeFactor * businessFactor

2. servicePrice += extraXXSS + extraSEM

3. taxableBase = servicePrice - promoDiscount

4. vat = taxableBase * 0.21

5. total = taxableBase + vat
```

### 5) Constraints
* **Age:** Must be an integer between 0 and 150.
* **Discount:** Must be a numeric value where 0 <= discount < basePrice.

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.
