# Simple Java KeyBind System for JFrame

> [!IMPORTANT]
> Potrzebujesz biblioteki [JNativeHook](https://github.com/kwhat/jnativehook) aby kod działał poprawnie!

## Jak dodać to do swojego kodu?
> To jest proste, wystarczy że posłużysz się tymi krokami!
1. Utwórz przycisk **JButton** (To będzie twój bind.)
2. Zainicjuj **BindManager** do swojego kodu.
```BindManager manager = new BindManager();```
3. Dodaj przycisk do managera:
```java
        manager.addButton(przycisk, new Bind() {
            @Override
            public void performAction() {
                // Tu wykona się funkcja
            }
        });
```
4. Gotowe!

