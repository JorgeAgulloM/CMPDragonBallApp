//
//  CharacterItem.swift
//  iosApp
//
//  Created by Jorge Agullo Martin on 12/11/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Shared
import Kingfisher

struct CharacterItem: View {
    let item: CharacterModel
    
    var body: some View {
        ZStack {
            DiamondShape()
                .fill(Color(.backgroundSecondary))
                .frame(width: 300, height: 300)
                .overlay(DiamondShape().stroke(
                     Color(.backgroundTertiary), lineWidth: 9))
                .rotationEffect(Angle(degrees: 180))
            
            VStack {
                Spacer()
                VStack {
                    Text(item.name).font(.headline)
                    Text(item.race).font(.subheadline)
                }.frame(maxWidth: .infinity)
                    .padding(8)
                    .background(RoundedRectangle(cornerRadius: 10).stroke(Color(.backgroundTertiary), lineWidth: 9).background(Color(.backgroundSecondary)))
                    .offset(y: 20)
            }
            
            KFImage(URL(string: item.image))
                .placeholder {
                    ProgressView()
                }.resizable()
                .scaledToFit()
                .frame(maxWidth: 150, maxHeight: 250)
            
        }.padding(.horizontal, 24).padding(.vertical, 24)
    }
}

#Preview {
    CharacterItem(
        item: CharacterModel(
            id: 1,
            name: "Vegeta",
            ki: "1000000",
            race: "Sayan",
            gender: "???",
            description: "Malote",
            image: "https://dragonball-api.com/characters/vegeta_normal.webp"
        )
    )
}
