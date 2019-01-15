package com.example.Testone;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TestoneApplication extends Application<TestoneConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TestoneApplication().run(args);
    }

    @Override
    public String getName() {
        return "Testone";
    }

    @Override
    public void initialize(final Bootstrap<TestoneConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final TestoneConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
