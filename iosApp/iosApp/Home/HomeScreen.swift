//
//  HomeScreen.swift
//  iosApp
//
//  Created by Jorge Agullo Martin on 11/11/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Shared
import KMPObservableViewModelSwiftUI
import KMPNativeCoroutinesAsync

struct HomeScreen: View {
    
    @StateViewModel
    var viewModel = HomeViewModel()
    
    var body: some View {
        Text(viewModel.example)
    }
}

#Preview {
    HomeScreen()
}
