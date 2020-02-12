package com.qa.ims.controller;

import org.apache.log4j.Logger;

import com.qa.ims.utils.Utils;

/**
<<<<<<< HEAD:src/main/java/com/qa/controller/Action.java
 * Action is a collection of commands which are used to determine the type of function to apply to an entity.
 *
 */
public enum Action {
	CREATE("To save a new item into the database"), 
	READ("To read an item from the database"),
	UPDATE("To change an item already in the database"), 
	DELETE("To remove an item from the database"),
=======
 * Action is a collection of commands which are used to determine the type of
 * function to apply to an entity.
 *
 */
public enum Action {
	CREATE("To save a new item into the database"), READ("To read an item from the database"),
	UPDATE("To change an item already in the database"), DELETE("To remove an item from the database"),
>>>>>>> daaa61cbbe27f08d182f3eeb0a9d53945b58fdbb:src/main/java/com/qa/ims/controller/Action.java
	RETURN("To return to domain selection");
	public static final Logger LOGGER = Logger.getLogger(Action.class);
	private String description;
<<<<<<< HEAD:src/main/java/com/qa/controller/Action.java
	Action(String description) {
		this.description = description;
	}
=======

	private Action() {
	}

	Action(String description) {
		this.description = description;
	}

>>>>>>> daaa61cbbe27f08d182f3eeb0a9d53945b58fdbb:src/main/java/com/qa/ims/controller/Action.java
	/**
	 * Describes the action
	 */
	public String getDescription() {
		return this.name() + ": " + this.description;
	}
<<<<<<< HEAD:src/main/java/com/qa/controller/Action.java
=======

>>>>>>> daaa61cbbe27f08d182f3eeb0a9d53945b58fdbb:src/main/java/com/qa/ims/controller/Action.java
	/**
	 * Prints out all possible actions
	 */
	public static void printActions() {
		for (Action action : Action.values()) {
			LOGGER.info(action.getDescription());
		}
	}
<<<<<<< HEAD:src/main/java/com/qa/controller/Action.java
	/**
	 * Gets an action based on a users input.
	 * If user enters a non-specified enumeration, it will ask for another input.
=======

	/**
	 * Gets an action based on a users input. If user enters a non-specified
	 * enumeration, it will ask for another input.
	 * 
>>>>>>> daaa61cbbe27f08d182f3eeb0a9d53945b58fdbb:src/main/java/com/qa/ims/controller/Action.java
	 * @return Action type
	 */
	public static Action getAction() {
		Action action;
		while (true) {
			try {
				action = Action.valueOf(Utils.getInput().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return action;
	}
}
