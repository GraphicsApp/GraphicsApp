# GraphicsApp Reborn

Neuimplementierung der GraphicsApp-Bibliothek ohne den ursprünglichen Processing-Kern.

## Ziele

Die GraphicsApp-Bibliothek ist eine einfache 2D-Grafikumgebung für die JAVA-Laufzeitumgebung. Sie dient in erster Linie
dazu, Programmiernovizen an die Verwendung der Programmiersprache Java heranzuführen. Die Programmierenden können auf Basis 
der Bibliothek eigene graphische Anwendungen gestalten. Grundlage dafür ist ein *Lifecycle*, bestehend aus einer 
Initalisierungsphase sowie eines einfachen *Game loop*. Die Bibliothek erlaubt das Erstellen, Darstellen und dynamisches 
Manipulieren graphischer Primitive. 

## Richtlinien für die Entwicklung

**Die Neu-Implementierung der GraphicsApp-Bibliothek erfolgt entlang der folgenden Richtlinien:**

1. Die nutzerseitige (Nutzer sind hier die Studierenden des OOP-Kurses) API der Bibliothek wird nicht oder nur behutsam 
verändert.

2. Das Starten einer Anwendung aus der Entwicklungsumgebung heraus muss mit minimalen Aufwand verbunden sein. 
Dem Dozierenden muss es möglich sein, lauffähige Projekte (z.B. Starterpakete) an die Studierenden zu verteilen, die 
auf allen unterstützten Plattformen direkt nach dem Import in die Entwicklungsumgebung gestartet werden können.

3. Der *Rendering*-Kern der neuen Bibliothek bietet gegenüber der bestehenden Lösung und für die bestehenden Beispielanwendungen 
und typische Studienleistungen eine vergleichbare oder bessere Performanz.

4. Bekannte Problemfelder (z.B. die Verbindung zum Dateisystem für den Im- und Export von Dateien) werden behoben und 
durch nachhaltige Lösungen ersetzt.

5. Fehlende oder unzuverlässige Funktionen werden sinnvoll ergänzt bzw. verbessert (z.B. Audiowiedergabe).

6. Die bestehende API wird hinsichtlich ihrer Vollständigkeit, Konsitenz und Versändlichkeit geprüft und ggf. optimiert.

7. Bestehende und neu hinzugefügte Funktionen werden anhand verständlicher, zielgruppenorientierter Anleitungen und
Beispiele dokumentiert.