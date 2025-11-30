package com.muhammadfairuzdzaki.frontend.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.muhammadfairuzdzaki.frontend.GameManager;

public class MenuState implements GameState {

    private GameStateManager gsm;
    private Stage stage;
    private Skin skin;
    private TextField nameField;
    private TextButton startButton;

    public MenuState(GameStateManager gsm) {
        this.gsm = gsm;
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        createBasicSkin();
        buildUI();
    }

    private void createBasicSkin() {
        skin = new Skin();

        skin.add("default", new BitmapFont());

        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE); pixmap.fill();
        skin.add("white", new Texture(pixmap));
        pixmap.setColor(Color.GRAY); pixmap.fill();
        skin.add("gray", new Texture(pixmap));
        pixmap.setColor(Color.DARK_GRAY); pixmap.fill();
        skin.add("dark_gray", new Texture(pixmap));
        pixmap.dispose();

        Label.LabelStyle labelStyle = new Label.LabelStyle(skin.getFont("default"), Color.WHITE);
        skin.add("default", labelStyle);

        TextField.TextFieldStyle tfStyle = new TextField.TextFieldStyle();
        tfStyle.font = skin.getFont("default");
        tfStyle.fontColor = Color.WHITE;
        tfStyle.background = skin.newDrawable("dark_gray");
        tfStyle.cursor = skin.newDrawable("white");
        tfStyle.selection = skin.newDrawable("gray");
        skin.add("default", tfStyle);

        TextButton.TextButtonStyle btnStyle = new TextButton.TextButtonStyle();
        btnStyle.font = skin.getFont("default");
        btnStyle.up = skin.newDrawable("gray");
        btnStyle.down = skin.newDrawable("white");
        btnStyle.over = skin.newDrawable("dark_gray");
        skin.add("default", btnStyle);
    }

    private void buildUI() {
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        Label title = new Label("NETLAB JOYRIDE", skin);
        title.setFontScale(2f);

        Label prompt = new Label("Enter Your Name:", skin);

        nameField = new TextField("", skin);
        nameField.setMessageText("Username...");
        nameField.setAlignment(Align.center);

        startButton = new TextButton("START GAME", skin);

        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String inputName = nameField.getText();
                if(inputName.isEmpty()) inputName = "Guest";

                GameManager.getInstance().registerPlayer(inputName);

                gsm.set(new PlayingState(gsm));
            }
        });

        table.add(title).padBottom(Gdx.graphics.getHeight() * 0.1f).row();
        table.add(prompt).padBottom(10).row();
        table.add(nameField).width(300).height(40).padBottom(20).row();
        table.add(startButton).width(200).height(50);
    }

    @Override
    public void update(float delta) {
        stage.act(delta);
    }

    @Override
    public void render(SpriteBatch batch) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
