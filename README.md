# fit-progression

Longo, Polanco, Fiore, Di Fede
Applicazione per la gestione delle schede di allenamenti in palestra (con la possibilità di analizzare il progresso nel tempo).

GitFit
Android:
Schermata di login e registrazione.
Al primo login, l’app propone un sondaggio per impostare il profilo dell’utente. 
La pagina principale permette di accedere alle varie sezioni: Profilo, Scheda, Esercizi e Calendario. 
Nella sezione Profilo è possibile vedere i propri dati e accedere ad un’area in cui sono visualizzabili i progressi dell’utente, divisi per esercizio e salvati su un database. 
Nella sezione Scheda è possibile accedere all’attuale elenco di esercizi salvati per l’utente, che possono essere “attivati” e marcati come svolti. Una volta attivato un esercizio, a schermo appare una barra che registra i progressi, a seconda che si tratti di un esercizio di ripetizioni o a tempo. 
Una volta concluso l’esercizio, i dati vengono salvati nella sezione Calendario e sul database. 
La sezione Esercizi permette di visualizzare la lista degli esercizi salvati su un server, cui l’app si collega tramite un servizio, e di effettuare operazioni di filtro e ricerca. Ogni esercizio è collegato a dei tag che agevolano la navigazione in questo senso e sono organizzati su criteri quali: gruppo muscolare di riferimento, livello di difficoltà, corpo libero o su macchina, fase di allenamento in una cornice temporale più ampia (ipertrofia, massa, definizione, eccetera). 
La sezione Calendario è dove si può visualizzare la frequenza degli allenamenti, assieme al tempo impiegato, tipologia di esercizi eseguiti. È possibile anche implementare una sorta di sottosezione riservata agli obiettivi, settimanali o mensili, da collegare eventualmente anche alla possibilità dell’app di inviare notifiche all’utente. 
Web:
Schermata principale del sito con icone che portano alle varie sezioni – le quali fanno da specchio a quelle dell’app -, e che rispondono all’hovering del cursore espandendosi per mostrare un box di testo con una breve descrizione della sezione presa in causa. 
La parte alta della schermata è occupata da una barra con dei pulsanti collegati alle diverse sezioni, un pulsante che riporta all’home e pulsanti di login e registrazione, sostituiti da un pulsante che riporta al profilo personale l’utente una volta effettuato il login.
I progressi del profilo utente legati a calendario e progressi personali sono condivisi da web e app. 
