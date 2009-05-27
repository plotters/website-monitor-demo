package ru.demax.sitemonitor.migrations;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class SiteMonitor0 extends ERXMigrationDatabase.Migration {
	@Override
	public NSArray<ERXModelVersion> modelDependencies() {
		return null;
	}
  
	@Override
	public void downgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
		// DO NOTHING
	}

	@Override
	public void upgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
		ERXMigrationTable websiteTable = database.newTableNamed("Website");
		websiteTable.newIntegerColumn("id", false);
		websiteTable.newStringColumn("name", 100, false);
		websiteTable.newStringColumn("url", 1000, false);
		websiteTable.create();
	 	websiteTable.setPrimaryKey("id");

	}
}