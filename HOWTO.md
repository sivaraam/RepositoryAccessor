Steps to include the RepositoryAccessor.jar into your Eclipse plug-in project
------------

1. Create a folder named `lib` inside your project repository (the com.asgoc.<project_name>.ui folder ).
2. Copy the `RepositoryAccessor.jar` file into the lib folder. It could be found [here](https://github.com/sivaraam/RepositoryAccessor/blob/master/dist/RepositoryAccessor.jar).
3. Make sure the `lib` folder appears in your Eclipse workspace. If it doesn't try refreshing your workspace.
4. Open the `build.properties` file. Switch to the **Runtime** tab in the window that appears.
5. In the **Classpath** section, click *Add* and choose the `RepositoryAccessor.java` file found in the `lib` folder.
6. Save the modifications
