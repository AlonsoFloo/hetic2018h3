//
//  Personne.swift
//  Groupe2iOS
//
//  Created by Florian ALONSO on 5/16/18.
//  Copyright © 2018 Hetic. All rights reserved.
//

import Foundation


class Personne {
    
    internal let nom: String
    let prenom: String
    var birthDay: Date?
    
    init (_ newNom: String, _ newPrenom: String) {
        self.nom = newNom
        self.prenom = newPrenom
    }
    
    func getAge() -> Double {
        let secondSince = self.birthDay?.timeIntervalSinceNow ?? 0.0
        return secondSince / (60.0*60.0*24.0*355.25)
    }
    
    func getAgeIfLet() -> Double {
        if let trueBirthday = self.birthDay, !self.nom.isEmpty {
            let secondSince = trueBirthday.timeIntervalSinceNow
            return secondSince / (60.0*60.0*24.0*355.25)
        }
        return 0.0
    }
    
    func getAgeGuardLet() -> Double {
        guard let trueBirthday = self.birthDay,
            self.prenom == "Florian"
            else {
                
            return 0.0
        }

        let secondSince = trueBirthday.timeIntervalSinceNow
        return secondSince / (60.0*60.0*24.0*355.25)
    }
}


func test() {
    let personne = Personne("ALONSO", "Florian")
    personne.nom
    
    
    
    var entierOptionel: Int? = 10
    entierOptionel = nil
    var entierCast: Int! = 10
    entierCast = nil
    var entier: Int = 10
    //entier = nil --> IMPOSSIBLE
}


