# roman-number

## Introduzione

Abbiamo fatto il progetto seguendo l'approccio TDD, dimostrabile dal fatto che, dopo il merge in develop dello sviluppo dei test la build fallisce

Abbiamo inserito un comando nel build.yml per cui la Build Automation non parte se il branch è di tipo feature

Nelle prossime sezioni inseriamo nei comandi la flag `-B` che indica _batch mode_ (senza interazione dell'utente)

## Processo di build (rilascio versione 2.0)

Questo è il risultato del comando: `mvn -B package --file pom.xml` (il comando utilizzato nella Build Automation)

```
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------------< it.unipd.mtts:roman-number >---------------------
[INFO] Building roman-number 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- jacoco-maven-plugin:0.8.11:prepare-agent (default) @ roman-number ---
[INFO] argLine set to -javaagent:/home/matteo-mazzaretto/.m2/repository/org/jacoco/org.jacoco.agent/0.8.11/org.jacoco.agent-0.8.11-runtime.jar=destfile=/home/matteo-mazzaretto/Desktop/Uni/MTTS/roman-number/target/jacoco.exec
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ roman-number ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/matteo-mazzaretto/Desktop/Uni/MTTS/roman-number/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ roman-number ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ roman-number ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/matteo-mazzaretto/Desktop/Uni/MTTS/roman-number/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ roman-number ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.1:test (default-test) @ roman-number ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running it.unipd.mtts.RomanPrinterTest
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.222 s - in it.unipd.mtts.RomanPrinterTest
[INFO] Running it.unipd.mtts.IntegerToRomanTest
[INFO] Tests run: 16, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.002 s - in it.unipd.mtts.IntegerToRomanTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 26, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- jacoco-maven-plugin:0.8.11:report (report) @ roman-number ---
[INFO] Loading execution data file /home/matteo-mazzaretto/Desktop/Uni/MTTS/roman-number/target/jacoco.exec
[INFO] Analyzed bundle 'roman-number' with 3 classes
[INFO] 
[INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ roman-number ---
[INFO] 
[INFO] --- maven-checkstyle-plugin:3.3.1:check (checkstyle-validation) @ roman-number ---
[INFO] Starting audit...
Audit done.
[INFO] You have 0 Checkstyle violations.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.878 s
[INFO] Finished at: 2025-05-03T10:54:17+02:00
[INFO] ------------------------------------------------------------------------
```

## Analisi statica del codice

Questo è il risultato del comando: `mvn -B checkstyle:check`

```
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------------< it.unipd.mtts:roman-number >---------------------
[INFO] Building roman-number 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-checkstyle-plugin:3.3.1:check (default-cli) @ roman-number ---
[INFO] Starting audit...
Audit done.
[INFO] You have 0 Checkstyle violations.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.249 s
[INFO] Finished at: 2025-05-03T11:09:26+02:00
[INFO] ------------------------------------------------------------------------
```

## Code coverage

Questo è il risultato del comando `mvn -B jacoco:report && grep -oP 'Total.*?<td class="ctr2">.*?</td>' target/site/jacoco/index.html |   sed -E 's/.*<td class="ctr2">([^<]+)<\/td>/ ✅ Coverage: \1/'`

Questo comando consente di generare il report di JaCoCo e di **estrarre dal file HTML la percentuale totale di code coverage**, mostrandola direttamente nel terminale.

1. `mvn -B jacoco:report`:

Genera il report JaCoCo in modalità batch (-B = non interattiva).

Produce i file HTML (tra cui index.html) nella directory target/site/jacoco.

2. `grep -oP 'Total.*?<td class="ctr2">.*?</td>' target/site/jacoco/index.html`:

Cerca nel file HTML la riga che contiene la parola Total seguita da una cella (<td>) che contiene la percentuale complessiva di copertura.

-oP usa Perl-compatible regex e restituisce solo la parte che combacia.

Il pattern isola la riga corrispondente alla copertura totale.

3. `sed -E 's/.*<td class="ctr2">([^<]+)<\/td>/ ✅ Coverage: \1/'`:

Estrae la percentuale trovata e la mostra con un'emoji e una dicitura leggibile:

\1 è la percentuale.

```
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------------< it.unipd.mtts:roman-number >---------------------
[INFO] Building roman-number 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- jacoco-maven-plugin:0.8.11:report (default-cli) @ roman-number ---
[INFO] Loading execution data file /home/matteo-mazzaretto/Desktop/Uni/MTTS/roman-number/target/jacoco.exec
[INFO] Analyzed bundle 'roman-number' with 3 classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.999 s
[INFO] Finished at: 2025-05-03T11:42:25+02:00
[INFO] ------------------------------------------------------------------------
 ✅ Coverage: 98%
 ```
