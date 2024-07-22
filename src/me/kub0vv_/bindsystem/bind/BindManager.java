package me.kub0vv_.bindsystem.bind;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class BindManager implements NativeKeyListener {
    private final Map<JButton, Bind> buttonActionMap = new HashMap<>();
    private JButton listeningButton = null;

    public BindManager() {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(this);
    }

    public void addButton(JButton button, Bind action) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterListeningState(button, action);
            }
        });
        buttonActionMap.put(button, action);
    }

    private void enterListeningState(JButton button, Bind action) {
        listeningButton = button;
        button.setText("...");
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        if (listeningButton != null) {
            int keyCode = e.getKeyCode();
            String keyText;

            if (keyCode == NativeKeyEvent.VC_ESCAPE) {
                keyText = "Bind: ?";
                buttonActionMap.get(listeningButton).resetKey();
            } else {
                keyText = "Bind: " + NativeKeyEvent.getKeyText(keyCode);
                buttonActionMap.get(listeningButton).setKeyCode(keyCode);
            }

            listeningButton.setText(keyText);
            listeningButton = null;
        } else {
            processKeyPress(e);
        }
    }

    private void processKeyPress(NativeKeyEvent e) {
        int keyCode = e.getKeyCode();
        for (Bind action : buttonActionMap.values()) {
            if (action.getKeyCode() == keyCode) {
                action.performAction();
            }
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
    }
}
