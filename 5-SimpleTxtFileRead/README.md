# VariousHomeworkAssignments
Various Homework and Assignments

Να αναπτύξετε πρόγραμμα σε Java το οποίο να επιτρέπει μέσω γραφικής διασύνδεσης χρήστη (gui) διάβασμα πληροφοριών φοιτητών από ένα αρχείο κειμένου .txt και εκτύπωση των πληροφοριών αυτών στη κονσόλα.
Κάθε φοιτητής (Student) χαρακτηρίζεται από 2 πεδία: επίθετο (surname: String), αριθμό μητρώου (am: int).
Μπορεί όμως να χαρακτηρίζεται και από επιπλέον 3ο πεδίο: αριθμός προηγούμενων πτυχίων (numberOfTitles: int).
Το αρχείο κειμένου (students.txt) περιέχει πληροφορίες και για τους φοιτητές και έχει την παρακάτω μορφή:
sadqwq
Alfas, 00001
Vitas, 00002
Gamas, 00003
Deltas, 20002, 1
Epsilos, 20001, 2
Zhtas, 44001

Κάθε γραμμή του αρχείου .txt περιέχει 2 ή 3 στοιχεία για κάθε φοιτητή.
(Hint: χρησιμοποιείστε StringTokenizer και τη μέθοδο countTokens για την κλήση του κατάλληλου κατασκευαστή αντικειμένων Student για κάθε γραμμή του αρχείου .txt).

Πέρα από τις κλάσεις των φοιτητών και της ανάγνωσης από το αρχείο .txt να αναπτύξετε κώδικα που να κατασκευάζει γραφικό περιβάλλον (jframe). Το jframe πρέπει να περιέχει 2 jbutton. 
Με το πάτημα του πρώτου jbutton το πρόγραμμα θα διαβάζει το αρχείο .txt και θα κατασκευάζει τους φοιτητές. Με το πάτημα του δεύτερου jbutton το πρόγραμμα να εκτυπώνει στη κονσόλα τις πληροφορίες όλων των φοιτητών που διάβασε στη μορφή:
-	Student (με numberOfTitles=null): “O foithths Alfas exei arithmo mhtrwou 00001. Den katexei mexri twra kanena ptyxio.”
-	Student (με 3 πεδία): “O foithths Deltas exei arithmo mhtrwou 20002. Einai epipleon metaptyxiakos foithths kai meta to peras ths trexousas foithshs tou tha katexei synolika 2 ptyxia.”

Δίνεται το αρχείο students.txt.

Μιλάμε ουσιαστικά για μια άσκηση που βασίζεται στη χρήση:
-	Class with two constructors.
-	Reading from txt file.
-	Jframe developing
-	Implementing ActionListeners.