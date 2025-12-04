    package org.insightcentre.election.controller;

    import java.lang.reflect.InvocationTargetException;
    import java.lang.reflect.Method;
    import java.util.Hashtable;
    import java.util.List;

    import org.insightcentre.election.datamodel.ApplicationObject;
    import org.insightcentre.election.datamodel.Scenario;

    import javafx.beans.property.ObjectProperty;
    import javafx.beans.property.SimpleObjectProperty;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.scene.control.Tab;
    import javafx.scene.control.TableColumn;
    import javafx.scene.control.TablePosition;
    import javafx.scene.control.TableView;

    public abstract class MatrixTab extends Tab {

    	protected static final String COLUMN_STYLE = "-fx-alignment: CENTER-RIGHT";

    	protected Scenario base;
    	protected final TableView<ObservableList<ObjectProperty<ApplicationObject>>> table = new TableView<>();
    	protected final Hashtable<String, ApplicationObject> hash = new Hashtable<>();

    	public MatrixTab(String text, Scenario base) {
    		super();
    		this.base = base;
    		setText(text);
    		initHash();
    		table.setEditable(true);
            table.setItems(createTableItems(base));
    		table.setOnMouseClicked(e -> {
    			@SuppressWarnings("rawtypes")
    			TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
    			System.out.println(
    					+pos.getColumn() + ", " + pos.getRow() + " | " + pos.getTableColumn().getCellData(pos.getRow()));
    		});
            setContent(table);
    	}

    	protected abstract void initHash();

    	protected ObservableList<ObservableList<ObjectProperty<ApplicationObject>>> createTableItems(Scenario base) {
    		final ObservableList<ObservableList<ObjectProperty<ApplicationObject>>> data = FXCollections.observableArrayList();
    		int columnIndex = 0;
    		TableColumn<ObservableList<ObjectProperty<ApplicationObject>>, String> col = createColumn("Row", columnIndex);
    		col.setEditable(false);
    		col.getStyleClass().add("row-header");
    		table.getColumns().add(col);

    		for (ApplicationObject obj : findColumns(base)) {
    			col = createColumn(obj.toString(), ++columnIndex);
    			table.getColumns().add(col);
    		}

    		for (ApplicationObject rowObj : findRows(base)) {
    			final ObservableList<ObjectProperty<ApplicationObject>> row = FXCollections.observableArrayList();
    			row.add(new SimpleObjectProperty<>(rowObj));
    			for (ApplicationObject colObj : findColumns(base)) {
    				row.add(new SimpleObjectProperty<>(findCell(base, rowObj, colObj)));
    			}
    			data.add(row);
    		}

    		return data;
    	}

    	protected TableColumn<ObservableList<ObjectProperty<ApplicationObject>>, String> createColumn(String name, int index) {
    		final TableColumn<ObservableList<ObjectProperty<ApplicationObject>>, String> col = new TableColumn<>(name);
    		col.setStyle(COLUMN_STYLE);
    		return col;
    	}

    	protected abstract List<ApplicationObject> findColumns(Scenario base);

    	protected abstract List<ApplicationObject> findRows(Scenario base);

    	protected ApplicationObject findCell(Scenario base, ApplicationObject row, ApplicationObject col) {
    		return hash.get(row.getId() + ":" + col.getId());
    	}

    	/**
    	 * Makes a label for a table cell by invoking a method on an application object, provided it is of
    	 * the required class.
    	 * @param obj the application object
    	 * @param clazz the required class of the application object
    	 * @param methodName the name of the method to be invoked
    	 * @return the label
    	 */
    	protected String makeLabel(ApplicationObject obj, Class<? extends ApplicationObject> clazz, String methodName) {
    		String label = null;
    		if (obj == null) {
    			label = "";
    		}
    		else if (obj.getClass().equals(clazz)) {
    			try {
    				Method method = clazz.getMethod(methodName);
    				label = method.invoke(obj).toString();
    			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
    				e.printStackTrace();
    			}
    		} else {
    			label = obj.name;
    		}
    		return label;
    	}
    }
