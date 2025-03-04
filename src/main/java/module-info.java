module isca.di.sll.maven {
	requires javafx.controls;
	requires javafx.fxml;
	requires jakarta.persistence;
	requires org.hibernate.orm.core;
	opens app to javafx.fxml;
	opens model to org.hibernate.orm.core;
	exports app;
}