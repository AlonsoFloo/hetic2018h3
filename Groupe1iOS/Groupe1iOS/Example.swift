//
//  Example.swift
//  Groupe1iOS
//
//  Created by Florian ALONSO on 5/16/18.
//  Copyright © 2018 Hetic. All rights reserved.
//

import Foundation

class Exemple {
    
    func run() {
        
        var age: Int = 20
        age = 25
        age += 1
        //age = "Texte" --> Impossible
        
        let ageLet = 20
        //ageLet = 25 --> Impossible
        
        var i = 0
        i += 1
        //i++ --> Impossible
        i -= 1
        //i-- --> Impossible
        
        let boolean = false
        
        
        for i in 0...5 {
            // 6 fois ici, de 0 a 5 compris
        }
        for i in 0..<5 {
            // 5 fois ici, de 0 a 5 non compris
        }
        
        
        let scores = [1,2,3,77,55,4547]
        scores.filter { (value) -> Bool in
            value % 2 == 0
            }.map { (value) -> String in
                "\(value)"
        }
        
        for value in scores {
            // 6 fois de 1 a 4547
        }
        scores.forEach { (value) in
            // 6 fois de 1 a 4547
        }
        scores.forEachCustom { (value) in
            // 6 fois de 1 a 4547
        }
        for value in scores.reversed() {
            // 6 fois de 4547 a 1
        }
        
        let _ = isTrue()
        let _ = isTrue(true)
        let _ = isTrue(true, andWithSecondValue: false)
        let _ = isTrue(true, orWithSecondValue: false)
        
        let _ = isFalse()
        let _ = isFalse(true)
        let _ = isFalse(true, andWithSecondValue: false)
        
        
        let unePersonne = Personne(nom: "Martin", prenom: "Florian")
        unePersonne.prenom
        unePersonne.nom
        
        
        
        let personneList = [
            Personne(nom: "Martin", prenom: "Florian"),
            Personne(nom: "Jean", prenom: "Michel"),
            Personne(nom: "Duran", prenom: "Lionnel"),
            Personne(nom: "Jean", prenom: "Philipes")
        ]
        
        // Dictionnaire, avec la cles --> Le nom de famille et une liste de personnes
        // ----- The old way
        var dictionnaire = [String: Array<Personne>]()
        for personne in personneList {
            let currentNom = personne.nom
            var currentArray = dictionnaire[currentNom]
            if currentArray == nil {
                currentArray = []
            }
            currentArray?.append(personne)
            dictionnaire[currentNom] = currentArray
        }
        
        // ----- The new way
        let dictionnaire2: [String: Array<Personne>] = Dictionary(grouping: personneList) { $0.nom }
        
        
        let totalDesNombrePairFoisCent = scores.filter {
            $0 % 2 == 0
        }.map {
            $0 * 100
        }.reduce(0) { (total, value) -> Int in
            return total + value
        }
        
        let centMultiple = scores.first { $0 % 100 == 0 }
        
    }
    
    func isTrue() -> Bool {
        return true
    }
    
    func isTrue(_ firstValue: Bool) -> Bool {
        return firstValue == true
    }
    
    func isTrue(_ firstValue: Bool, andWithSecondValue i: Bool) -> Bool {
        return firstValue == true
            && i == true
    }
    
    func isTrue(_ firstValue: Bool, orWithSecondValue i: Bool) -> Bool {
        return firstValue == true
            || i == true
    }
    
    
    
    func isFalse(_ firstValue: Bool = false, andWithSecondValue i: Bool = false) -> Bool {
        return firstValue == false
            && i == false
    }
    
}


extension Array where Element == Int {
    
    func forEachCustom(_ block: (Int) -> Void) {
        for value in self {
            block(value)
        }
    }
    
}
