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
        scores.forEach { (value) in
            // 1 puis 2 puis 3
        }
        
        for value in scores.reversed() {
            // 3 puis 2 puis 1
        }
        
        var totalDesChiffrePairMutliperParCent = 0
        for value in scores {
            if value % 2 == 0 {
                totalDesChiffrePairMutliperParCent += value * 100
            }
        }
        let bisTotalDesChiffrePairMutliperParCent =
            scores.filter { $0 % 2 == 0}
                .map { $0 * 100 }
                .reduce(0) { (total, value) -> Int in
                    return total + value
                }
        
        
        let _ = isTrue()
        let _ = isTrue(true)
        let _ = isTrue(true, andWithASecondValue: false)// --> RESULT : FALSE
        let _ = isTrue(true, orWithASecondValue: true)
        
        
        let _ = isFalse() 
        let _ = isFalse(true) // Firstvalue --> TRUE, secondValue --> FALSE, RESULT --> FALSE
        let _ = isFalse(true, andWithASecondValue: false)
        
    }
    
    func isFalse(_ firstValue: Bool = false, andWithASecondValue b: Bool = false) -> Bool {
        return firstValue == false
            && b == false
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
