module isca.di.sll.maven {
	requires javafx.controls;

	requires javafx.fxml;

	requires jakarta.persistence;

	requires org.hibernate.orm.core;

	requires java.sql;

	opens app to javafx.fxml;

	opens model to org.hibernate.orm.core;

	opens controller.auth to javafx.fxml;

	opens controller.main to javafx.fxml;

	exports app;

	exports controller.auth to javafx.fxml;

	exports controller.main to javafx.fxml;
}