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
        for value in scores {
            // 6 fois de 1 a 4547
        }
        for value in scores.reversed() {
            // 6 fois de 4547 a 1
        }
        
        let _ = isTrue()
        let _ = isTrue(true)
        let _ = isTrue(true, andWithSecondValue: false)
        let _ = isTrue(true, orWithSecondValue: false)
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
    
    
    
    
    
    
}
