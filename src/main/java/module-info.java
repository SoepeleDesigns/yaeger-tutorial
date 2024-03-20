module waterworld {
    requires hanyaeger;
    requires com.google.guice;

    exports com.github.hanyaeger.tutorial;

    opens audio;
    opens backgrounds;
    opens sprites;
    exports com.github.hanyaeger.tutorial.entities.swordfish;
    exports com.github.hanyaeger.tutorial.entities.bubbles;
    exports com.github.hanyaeger.tutorial.entities.map;
    exports com.github.hanyaeger.tutorial.entities.buttons;
    exports com.github.hanyaeger.tutorial.scenes;
    exports com.github.hanyaeger.tutorial.entities;
    exports com.github.hanyaeger.tutorial.entities.text;

}
