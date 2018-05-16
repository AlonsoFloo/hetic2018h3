//
//  Exemple.swift
//  Groupe2iOS
//
//  Created by Florian ALONSO on 5/16/18.
//  Copyright © 2018 Hetic. All rights reserved.
//

import Foundation

class Exemple {
    func run() {
        let scores = [1,2,3]
        
        for value in scores {
            // 1 puis 2 puis 3
        }
        
        for value in scores.reversed() {
            // 3 puis 2 puis 1
        }
        
        let _ = isTrue()
        let _ = isTrue(true)
        let _ = isTrue(true, andWithASecondValue: true)
        let _ = isTrue(true, orWithASecondValue: true)
        
    }
    
    func isTrue() -> Bool {
        return true
    }
    
    func isTrue(_ firstValue: Bool) -> Bool {
        return firstValue == true
    }
    
    func isTrue(_ firstValue: Bool, andWithASecondValue secondValue: Bool) -> Bool {
        return firstValue == true
            && secondValue == true
    }
    
    func isTrue(_ firstValue: Bool, orWithASecondValue secondValue: Bool) -> Bool {
        return firstValue == true
            || secondValue == true
    }
}
