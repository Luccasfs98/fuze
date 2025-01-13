# fuze
Application for consultation of CSGO matches


The application follows the MVVM architecture added to SOLID concepts. 
It also uses the main Jetpack libraries, which is Google's recommendation for sustainable and scalable applications. 

The project is modularized, where the app module only has the responsibility of initializing the application. The new native Android splash screen was also used in MainActivity, but only for Android 12 or higher. 

Modules:
	Core: Responsible for providing essential resources for the app to function, such as dependency injection and API request configurations.
	Comom: Assists in providing commonly accessible utility classes.
	UI: Module responsible for the componentization of layouts whose objective would be code reuse and easy maintenance.
	matches: Functionality module, separated by packages, data, di, presentation and Domain. With the aim of separating responsibilities by layers, following the principle of single responsibility and also facilitating future unit and integrated tests.
