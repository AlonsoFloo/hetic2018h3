//
//  Personne.swift
//  Groupe1iOS
//
//  Created by Florian ALONSO on 5/16/18.
//  Copyright © 2018 Hetic. All rights reserved.
//

import Foundation

class Personne {
    
    let nom: String
    let prenom: String
    var birthday: Date?
    var friendList = [Personne]()
    
    init (nom: String, prenom: String) {
        self.nom = nom
        self.prenom = prenom
    }
    
    func getAgeWithDefault() -> Double {
        let timestamp = birthday?.timeIntervalSince(Date()) ?? 0
        return (timestamp) / 60.0 * 60.0 * 24.0 * 356.25
    }
    
    func getAgeWithLet() -> Double {
        if let trueBirthay = self.birthday, !nom.isEmpty, prenom == "Florian" {
            let now = Date()
            let timestamp = trueBirthay.timeIntervalSince(now)
            return (timestamp) / 60.0 * 60.0 * 24.0 * 356.25
            
        }
        return 0.0
    }
    
    func getAgeWithGuard() -> Double {
        guard let trueBirthay = self.birthday, !nom.isEmpty, prenom == "Florian" else {
            return 0.0
        }
        
        let now = Date()
        let timestamp = trueBirthay.timeIntervalSince(now)
        return (timestamp) / 60.0 * 60.0 * 24.0 * 356.25
    }
    
    
    func isFriendWith(_ friend: Personne?, byFirstName: Bool) -> Bool {
        if let trueFriend = friend {
            return friendList.contains(where: { (currentValue) -> Bool in
                if (byFirstName) {
                    return currentValue.nom == trueFriend.nom
                } else {
                    return currentValue.prenom == trueFriend.prenom
                }
            })
        }
        return false
    }
    
    func isFriendWithGuard(_ friend: Personne?, byFirstName: Bool) -> Bool {
        guard let trueFriend = friend else {
            return false
        }
        
        
        return friendList.contains(where: { (currentValue) -> Bool in
            if (byFirstName) {
                return currentValue.nom == trueFriend.nom
            } else {
                return currentValue.prenom == trueFriend.prenom
            }
        })
    }
    
    
    
    
    
    
    
    
    
}
