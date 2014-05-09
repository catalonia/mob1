//
//  AskContactCell.m
//  TasteSync
//
//  Created by Phu Phan on 11/9/13.
//  Copyright (c) 2013 Mobioneer. All rights reserved.
//

#import "AskContactCell.h"
#import "RateCustom.h"

@implementation AskContactCell

- (id)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier
{
    self = [super initWithStyle:style reuseIdentifier:reuseIdentifier];
    if (self) {
        // Initialization code
    }
    return self;
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated
{
    [super setSelected:selected animated:animated];

    // Configure the view for the selected state
}
-(IBAction)pressButton:(id)sender
{
    UIButton* button = (UIButton*)sender;
    [self.delegate pressButtonAtIndex:button.tag forcell:self];
}

-(void)refreshView
{
    if (_askObject.object.type == GlobalDataRate) {
        RateCustom *rateCustom = [[RateCustom alloc] initWithFrame:CGRectMake(15, 18, 30, 4)];
        [rateCustom setRateMedium:_askObject.object.name.length];
        [_view addSubview:rateCustom];
        rateCustom.allowedRate = NO;
        _name.frame = CGRectMake(_name.frame.origin.x + 90, _name.frame.origin.y + 6, _name.frame.size.width, _name.frame.size.height);
        _name.text = @"";
        if (_askObject.object.name.length != 5) {
            _name.text = @"+";
        }
        
    }
    if (_askObject.object.cityObj != nil) {
        if (![_askObject.object.cityObj.neighbourhoodID isEqualToString:@""]) {
            _name.text = [NSString stringWithFormat:@"   %@", _askObject.object.name];
        }
    }
}


@end
